package com.example.financeapp.exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException() {
        super("User with this username already exist.");
    }
}
