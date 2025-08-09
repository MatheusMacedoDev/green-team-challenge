package com.macedo.backend_challenge.infra.security.authentication;

import com.auth0.jwt.exceptions.JWTCreationException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.macedo.backend_challenge.domain.entities.GameMaster;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;

public class JwtTokenStrategy implements TokenStrategy {

    @Value("${JWT_SECRET}")
    private String jwtSectret;

    public String generateToken(GameMaster gameMaster) {
        try {

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
        Algorithm algorithm = Algorithm.HMAC256(jwtSectret);

        return JWT.create()
                .withIssuer("diet-maker-api")
                .withSubject(gameMaster.getEmail())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSectret);
            return JWT.require(algorithm)
                    .withIssuer("diet-maker-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
