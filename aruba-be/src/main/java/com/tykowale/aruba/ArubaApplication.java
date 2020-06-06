package com.tykowale.aruba;

import com.tykowale.aruba.config.ArubaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ArubaProperties.class)
public class ArubaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArubaApplication.class, args);
    }

}
