package com.example.financeapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financeapp.domain.dto.ResponseUserDTO;
import com.example.financeapp.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseUserDTO getMethodName(@PathVariable Long id) {
        return userService.getById(id);
    }
    
}
