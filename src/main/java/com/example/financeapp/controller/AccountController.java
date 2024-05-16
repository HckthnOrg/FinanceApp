package com.example.financeapp.controller;

import com.example.financeapp.domain.dto.AccountDTO;
import com.example.financeapp.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Account")
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    @Operation(summary = "Get user account")
    public AccountDTO getAccount() {
        return accountService.getUserAccount();
    }
}
