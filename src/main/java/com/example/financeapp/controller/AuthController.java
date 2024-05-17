package com.example.financeapp.controller;

import com.example.financeapp.domain.dto.JwtAuthenticationResponse;
import com.example.financeapp.domain.dto.SignInRequest;
import com.example.financeapp.domain.dto.SignUpRequest;
import com.example.financeapp.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    @Operation(summary = "Users registration")
    public JwtAuthenticationResponse singUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Users authentication")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
