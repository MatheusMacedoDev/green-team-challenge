package com.macedo.backend_challenge.configurations;

import com.macedo.backend_challenge.infra.security.cryptography.Argon2idCryptographyStrategy;
import com.macedo.backend_challenge.infra.security.cryptography.CryptographyStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CryptographyConfig {

    @Bean
    public CryptographyStrategy cryptographyStrategy() {
        return new Argon2idCryptographyStrategy();
    }

}
