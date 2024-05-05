package com.example.financeapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDto {

    @NotBlank
    @Size(min = 5, max = 15, message = "Login length must be between 5 and 15")
    private String login;

    @NotBlank
    @Size(min = 8, max = 32, message = "Password length must be between 8 and 32")
    private String password;

    @NotBlank
    @Size(min = 2, max = 32, message = "First name length must be between 2 and 32")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 32, message = "Second name length must be between 2 and 32")
    private String lastName;
}
