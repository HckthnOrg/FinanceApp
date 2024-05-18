package com.example.financeapp.exception;

public class UserIdNotFoundException extends RuntimeException {
    public UserIdNotFoundException(Long id) {
        super(String.format("User with %d id not found.", id));
    }
}
