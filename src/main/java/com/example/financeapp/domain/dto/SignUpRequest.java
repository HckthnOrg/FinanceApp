package com.example.financeapp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request for sign up")
public class SignUpRequest {
    @Schema(description = "User name", example = "Jhon")
    @Size(min = 5, max = 32, message = "Username length must be between 5 and 32")
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Schema(description = "User email", example = "jhondoe@gmail.com")
    @Size(min = 5, max = 32, message = "User email length must be between 5 and 32")
    @NotBlank(message = "User email is mandatory")
    @Email(message = "User email should be formated as user@example.com")
    private String email;

    @Schema(description = "Password", example = "mySecretPassword12345!")
    @Size(min = 8, max = 256, message = "Password length must be between 8 and 256")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @Schema(description = "User real first name", example = "Alex")
    @Size(min = 1, max = 32, message = "User real first name length must be between 1 and 128")
    private String firstName;

    @Schema(description = "User real last name", example = "Morozov")
    @Size(min = 1, max = 32, message = "User real second name length must be between 1 and 128")
    private String lastName;
}
