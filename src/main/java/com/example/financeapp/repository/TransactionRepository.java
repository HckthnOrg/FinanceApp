package com.example.financeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.financeapp.repository.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
