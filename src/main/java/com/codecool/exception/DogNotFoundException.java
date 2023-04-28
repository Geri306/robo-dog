package com.codecool.exception;

public class DogNotFoundException extends RuntimeException {

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public DogNotFoundException() {
    }

    public DogNotFoundException(String message) {
        super(message);
    }

    public DogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DogNotFoundException(Throwable cause) {
        super(cause);
    }
}
