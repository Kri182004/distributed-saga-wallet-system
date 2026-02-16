package com.kritika.sagawallet.exceptions;

public class SagaException extends RuntimeException {
    public SagaException(String message) {
        super(message);
    }

    public SagaException(String message, Throwable cause) {
        super(message, cause);
    }
}
