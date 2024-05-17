package com.example.financeapp.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {

    @NotBlank
    private Long id;

    @NotBlank
    @Size(min = 5, max = 15, message = "Login length must be between 5 and 15")
    private String login;

    @NotBlank
    @Size(min = 2, max = 32, message = "First name length must be between 2 and 32")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 32, message = "Second name length must be between 2 and 32")
    private String lastName;
}
