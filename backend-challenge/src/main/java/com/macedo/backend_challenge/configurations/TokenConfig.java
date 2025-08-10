package com.macedo.backend_challenge.configurations;

import com.macedo.backend_challenge.infra.security.auth.JwtTokenStrategy;
import com.macedo.backend_challenge.infra.security.auth.TokenStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

    @Bean
    public TokenStrategy tokenStrategy() {
        return new JwtTokenStrategy();
    }

}
