package com.tykowale.aruba.security.jwt;

import com.tykowale.aruba.config.ArubaProperties;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TokenProvider {

    // Autowired stuff here
    private final ArubaProperties arubaProperties;


    // class variables that are not autowired
    private static final String AUTHORITIES_KEY = "auth";
    private Key key;
    private long tokenValidityInMilliseconds;
    private long tokenValidityInMillisecondsForRememberMe;

    @Autowired
    public TokenProvider(ArubaProperties arubaProperties) {
        this.arubaProperties = arubaProperties;
    }

    @PostConstruct
    public void init() {
        String secret = arubaProperties.getSecurity().getJwt().getBase64Secret();
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.tokenValidityInMilliseconds = 1000 * arubaProperties.getSecurity().getJwt().getTokenValidityInSeconds();
        this.tokenValidityInMillisecondsForRememberMe = 1000 * arubaProperties.getSecurity().getJwt().getTokenValidityInSecondsForRememberMe();
    }

    public String createToken(Authentication authentication, boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date expiry;

        if (rememberMe) {
            expiry = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            expiry = new Date(now + this.tokenValidityInMilliseconds);
        }

        return Jwts.builder()
            .setSubject(authentication.getName())
            .claim(AUTHORITIES_KEY, authorities)
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(expiry)
            .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
            .setSigningKey(key)
            .parseClaimsJws(token)
            .getBody();
        Collection<? extends GrantedAuthority> authorities =
            Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace.", e);
        }
        return false;
    }
}
