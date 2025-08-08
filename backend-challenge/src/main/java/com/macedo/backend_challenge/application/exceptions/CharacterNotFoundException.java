package com.macedo.backend_challenge.application.exceptions;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException() {
        super("There is no character with this id");
    }

}
