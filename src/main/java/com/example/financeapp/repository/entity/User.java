package com.example.financeapp.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, length = 12)
    private String login;
    private String password;

    protected User() {}

    public User(String login, String password) {
        // validation
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return this.login;
    }
}
