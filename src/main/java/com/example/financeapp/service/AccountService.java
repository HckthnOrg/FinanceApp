package com.example.financeapp.service;

import com.example.financeapp.domain.entity.Account;
import com.example.financeapp.domain.entity.User;
import com.example.financeapp.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account createAccount(User user) {
        Account newAccount = new Account();
        newAccount.setUser(user);

        return accountRepository.save(newAccount);
    }

    public List<Account> getAccountsByUserId() {
        // TODO: get account by user id
        return new ArrayList<>();
    }
}
