package com.example.security.configuration;

import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgorithmConfiguration {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public Algorithm algorithm() {
        return Algorithm.HMAC256(secret.getBytes());
    }
}
