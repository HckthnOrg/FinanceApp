package com.example.financeapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.financeapp.domain.dto.CategoryDTO;
import com.example.financeapp.domain.dto.RequestTransactionDTO;
import com.example.financeapp.domain.dto.ResponseTransactionDTO;
import com.example.financeapp.domain.entity.Category;
import com.example.financeapp.domain.entity.Transaction;
import com.example.financeapp.exception.CategoryNotFoundException;
import com.example.financeapp.exception.TransactionNotFoundException;
import com.example.financeapp.repository.CategoryRepository;
import com.example.financeapp.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;


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

    public ResponseTransactionDTO createTransaction(RequestTransactionDTO requestTransactionDTO) {
        Category category = categoryRepository.findById(requestTransactionDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException());
        
        Transaction transaction = Transaction.builder()
            .value(requestTransactionDTO.getValue())
            .type(requestTransactionDTO.getType())
            .description(requestTransactionDTO.getDescription())
            .category(category)
            .date(requestTransactionDTO.getDate())
            .build();
        
        return convertToDTO(transactionRepository.save(transaction));
    }

    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException());
        transactionRepository.delete(transaction);
    }

    public ResponseTransactionDTO updateTransaction(Long id, RequestTransactionDTO requestTransactionDTO) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException());
        Category category = categoryRepository.findById(requestTransactionDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException());
        
        transaction.setValue(requestTransactionDTO.getValue());
        transaction.setType(requestTransactionDTO.getType());
        transaction.setDescription(requestTransactionDTO.getDescription());
        transaction.setCategory(category);
        transaction.setDate(requestTransactionDTO.getDate());
        
        return convertToDTO(transactionRepository.save(transaction));
    }

    private ResponseTransactionDTO convertToDTO(Transaction transaction) {
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
