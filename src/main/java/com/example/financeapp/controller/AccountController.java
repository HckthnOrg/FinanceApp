package com.example.financeapp.controller;

import com.example.financeapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/account")
public class AccountController {

    private AccountService accountService;

    @GetMapping("/{id}")
    public String getAccount(@RequestParam long id) {
        //TODO: list accounts

        return "";
    }
}
