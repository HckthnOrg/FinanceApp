package com.example.financeapp.service;

import org.springframework.stereotype.Service;

import com.example.financeapp.domain.dto.ResponseTransactionDTO;
import com.example.financeapp.domain.entity.Transaction;
import com.example.financeapp.exception.TransactionNotFoundException;
import com.example.financeapp.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    TransactionRepository transactionRepository;

    public ResponseTransactionDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException());

        return new ResponseTransactionDTO(
            transaction.getId(),
            transaction.getValue(),
            transaction.getType(),
            transaction.getDescription(),
            transaction.getCategory(),
            transaction.getDate(),
            transaction.getCreatedAt()
        );
    }
}
