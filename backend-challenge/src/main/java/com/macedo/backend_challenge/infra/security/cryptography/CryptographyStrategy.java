package com.macedo.backend_challenge.infra.security.cryptography;

public interface CryptographyStrategy {
    byte[] generateSalt();
    byte[] hashPassword(String passwordText, byte[] salt);
    boolean passwordMatches(String passwordText, byte[] passwordSalt, byte[] passwordHash);
}
