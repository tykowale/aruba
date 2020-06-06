package com.tykowale.aruba.security.jwt;

import com.tykowale.aruba.config.ArubaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class TokenProvider {

    private final ArubaProperties arubaProperties;

    @Autowired
    public TokenProvider(ArubaProperties arubaProperties) {
        this.arubaProperties = arubaProperties;
    }

    @PostConstruct
    public void init() {
    }
}
