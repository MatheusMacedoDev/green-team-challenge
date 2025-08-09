package com.macedo.backend_challenge.infra.security.authentication;

import com.macedo.backend_challenge.domain.entities.GameMaster;

public interface TokenStrategy {
    String generateToken(GameMaster gameMaster);
    String validateToken(String token);
}
