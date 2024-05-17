package com.example.financeapp.exception;

public class EmailAlreadyTakenException extends RuntimeException {
    public EmailAlreadyTakenException() {
        super("This email already taken.");
    }
}
