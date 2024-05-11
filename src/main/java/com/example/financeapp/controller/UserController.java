package com.example.financeapp.controller;

import com.example.financeapp.dto.UserRegisterDto;
import com.example.financeapp.dto.UserResponseDto;
import com.example.financeapp.exception.UserAlreadyExistsException;
import com.example.financeapp.repository.entity.User;
import com.example.financeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

}
