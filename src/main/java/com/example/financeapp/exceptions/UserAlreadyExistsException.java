package com.example.financeapp.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException() {
        super("User with this username already exist.");
    }
}
