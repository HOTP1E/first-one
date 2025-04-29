package ru.crew.management.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
