package com.codecool.exception;

public class DogIdMismatchException extends RuntimeException {

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public DogIdMismatchException() {
    }

    public DogIdMismatchException(String message) {
        super(message);
    }

    public DogIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DogIdMismatchException(Throwable cause) {
        super(cause);
    }
}
