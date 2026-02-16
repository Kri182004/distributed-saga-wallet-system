package com.kritika.sagawallet.exceptions;


public class InsufficientBalanceException extends WalletException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}