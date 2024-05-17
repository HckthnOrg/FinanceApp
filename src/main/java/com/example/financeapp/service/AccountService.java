package com.example.financeapp.service;

import com.example.financeapp.domain.dto.AccountDTO;
import com.example.financeapp.domain.entity.Account;
import com.example.financeapp.domain.entity.Category;
import com.example.financeapp.domain.entity.User;
import com.example.financeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;

    public AccountDTO getUserAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        User currentUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found."));
        Account account = currentUser.getAccount();

        List<String> categoryNames = account.getCategories().stream()
                .map(Category::getCategoryName)
                .collect(Collectors.toList());

        return new AccountDTO(
                account.getId(),
                account.getUser().getId(),
                account.getBalance(),
                account.getTransactionAmount(),
                account.getCreatedAt(),
                categoryNames
        );
    }

    public void configureAccount(Account account) {
        account.setBalance(0L);
        account.setTransactionAmount(0L);
        account.setCategories(new ArrayList<>());
    }
}
