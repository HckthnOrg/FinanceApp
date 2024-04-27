package com.example.financeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financeapp.repository.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {}
