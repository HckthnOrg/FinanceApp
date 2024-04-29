package com.example.financeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.financeapp.dto.UserRegister;
import com.example.financeapp.exceptions.UserAlreadyExistException;
import com.example.financeapp.repository.entity.User;
import com.example.financeapp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping(value = "/create", consumes = {"application/json"})
    public String createUser(@RequestBody UserRegister userRegister) {
        try {
            User user = userService.registerUser(userRegister);
            return String.format("Success user #%s registered", user.getId());
        } catch (UserAlreadyExistException e) {
            return "User already exist";
        }
    }
}
