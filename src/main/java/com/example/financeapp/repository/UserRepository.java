package com.example.financeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financeapp.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
