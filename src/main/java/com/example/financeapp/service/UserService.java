package com.example.financeapp.service;

import com.example.financeapp.dto.UserRegisterDto;
import com.example.financeapp.exceptions.UserAlreadyExistException;
import com.example.financeapp.repository.UserRepository;
import com.example.financeapp.repository.entity.User;
import jakarta.transaction.Transactional;
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

    @Transactional
    public User registerUser(UserRegisterDto userDto) throws UserAlreadyExistException {
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
