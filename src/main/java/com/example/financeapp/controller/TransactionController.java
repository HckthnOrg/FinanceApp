package com.example.financeapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @GetMapping("/user/{id}")
    public String getAllTransactions() {
        return "All transactions";
    }
}
