package com.example.financeapp.controller;

import com.example.financeapp.dto.UserRegisterDto;
import com.example.financeapp.dto.UserResponseDto;
import com.example.financeapp.exceptions.UserAlreadyExistException;
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

    private final UserService userService;

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<Object> createUser(@RequestBody UserRegisterDto userDto) {
        try {
            User user = userService.registerUser(userDto);
            UserResponseDto responseDto = new UserResponseDto(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName());
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
