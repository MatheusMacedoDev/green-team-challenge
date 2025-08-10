package com.macedo.backend_challenge.infra.security.auth;

import com.macedo.backend_challenge.domain.entities.GameMaster;

public interface TokenStrategy {
    String generateToken(GameMaster gameMaster);
    String getSubjectFromToken(String token);
}
