package com.macedo.backend_challenge.application.exceptions;

public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException() {
        super("Invalid login data");
    }

}
