package com.example.financeapp.service;

import com.example.financeapp.domain.dto.ResponseUserDTO;
import com.example.financeapp.domain.entity.Account;
import com.example.financeapp.domain.entity.User;
import com.example.financeapp.exception.EmailAlreadyTakenException;
import com.example.financeapp.exception.UserAlreadyExistsException;
import com.example.financeapp.exception.UserIdNotFoundException;
import com.example.financeapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
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

        Account account = new Account();
        account.setUser(user);
        accountService.configureAccount(account);
        user.setAccount(account);

        return save(user);
    }

    public ResponseUserDTO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id));
        return new ResponseUserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getAccount(),
                user.getCreatedAt()
        );
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found."));
    }

    /*
     * Get user by username.
     * <p>
     * Needed for Spring Security.
     *
     * @return the user
     */
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        // Get username from the Spring Security context
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}
