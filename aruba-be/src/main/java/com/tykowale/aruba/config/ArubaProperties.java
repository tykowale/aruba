package com.tykowale.aruba.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties("aruba")
public class ArubaProperties {
    private final Security security = new Security();


    @Getter
    public static class Security {

        private final Jwt jwt = new Jwt();

        @Data
        public static class Jwt {
            String base64Secret = null;
            long tokenValidityInSeconds = 1800; // 30 minutes
            long tokenValidityInSecondsForRememberMe = 2592000; // 30 days
        }
    }
}
