package com.example.financeapp.service;

import org.springframework.stereotype.Service;

import com.example.financeapp.repository.AccountRepository;
import com.example.financeapp.repository.entity.Account;
import com.example.financeapp.repository.entity.User;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(User user) {
        Account newAccount = new Account();
        newAccount.setUser(user);

        return accountRepository.save(newAccount);
    }
}
