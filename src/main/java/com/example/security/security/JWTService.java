package com.example.security.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import static com.example.security.constants.SecurityConstants.ROLES;

@Service
@RequiredArgsConstructor
public class JWTService {
    private final Algorithm algorithm;
    @Value("${jwt.secret})")
    private String secret;
    @Value("${jwt.expired}")
    private long expired;

    public String generateToken(UserDetails userDetails) {
        return JWT.create()
            .withSubject(userDetails.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + expired))
            .withClaim(ROLES, userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
            .sign(algorithm);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return JWT.create()
            .withSubject(userDetails.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + expired * 2))
            .sign(algorithm);
    }
}
