package com.tykowale.aruba.security.jwt;

import com.tykowale.aruba.config.ArubaProperties;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;

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
}
