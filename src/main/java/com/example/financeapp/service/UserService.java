package com.example.financeapp.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.financeapp.dto.UserRegister;
import com.example.financeapp.exceptions.UserAlreadyExistException;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.repository.entity.Account;
import com.example.financeapp.repository.entity.User;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AccountService accountService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountService = accountService;
    }

    @Transactional
    public User registerUser(UserRegister userDto) throws UserAlreadyExistException {
        if (userRepository.findByLogin(userDto.getLogin()) != null) {
            throw new UserAlreadyExistException();
        }

        User newUser = new User();
        newUser.setLogin(userDto.getLogin());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setAccount(accountService.createAccount(newUser));

        return userRepository.save(newUser);
    }
}
