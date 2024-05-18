package com.example.financeapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financeapp.domain.dto.RequestTransactionDTO;
import com.example.financeapp.domain.dto.ResponseTransactionDTO;
import com.example.financeapp.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Transaction")
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    TransactionService transactionService;

    @GetMapping("/user/{id}")
    public String getAllTransactions() {
        return "All transactions";
    }

    @PostMapping
    public ResponseTransactionDTO createTransaction(@RequestBody RequestTransactionDTO transaction) {
        return transactionService.createTransaction(transaction);
    }

    @PutMapping("/{id}")
    public ResponseTransactionDTO updateTransaction(@PathVariable Long id, @RequestBody RequestTransactionDTO transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

    //TODO: Add more endpoints (get by id, get by category, get by date, etc.)
}
