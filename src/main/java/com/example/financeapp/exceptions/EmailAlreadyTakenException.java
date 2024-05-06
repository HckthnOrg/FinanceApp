package com.example.financeapp.exceptions;

public class EmailAlreadyTakenException extends RuntimeException {
    public EmailAlreadyTakenException() {
        super("This email already taken.");
    }
}
