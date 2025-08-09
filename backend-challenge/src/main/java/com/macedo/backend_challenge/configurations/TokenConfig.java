package com.macedo.backend_challenge.configurations;

import com.macedo.backend_challenge.infra.security.authentication.JwtTokenStrategy;
import com.macedo.backend_challenge.infra.security.authentication.TokenStrategy;
import com.macedo.backend_challenge.infra.security.cryptography.Argon2idCryptographyStrategy;
import com.macedo.backend_challenge.infra.security.cryptography.CryptographyStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Bean
    public TokenStrategy tokenStrategy() {
        return new JwtTokenStrategy();
    }

}
