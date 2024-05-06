package com.example.financeapp.service;

import com.example.financeapp.exceptions.EmailAlreadyTakenException;
import com.example.financeapp.exceptions.UserAlreadyExistsException;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException();
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyTakenException();
        }

        return save(user);
    }
}
