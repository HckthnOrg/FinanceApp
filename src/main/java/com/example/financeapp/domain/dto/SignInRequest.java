package com.example.financeapp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request for sign in")
public class SignInRequest {
    @Schema(description = "User name", example = "Jhon")
    @Size(min = 5, max = 32, message = "Username length must be between 5 and 32")
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Schema(description = "password", example = "mySecretPassword12345!")
    @Size(min = 8, max = 256, message = "Password length must be between 8 and 256")
    @NotBlank(message = "Password is mandatory")
    private String password;
}
