package com.example.financeapp.domain.dto;

import java.util.Date;

import com.example.financeapp.domain.entity.Account;
import com.example.financeapp.domain.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representing a user")
public class ResponseUserDTO {
    @NotNull
    @Schema(description = "The ID of the user", example = "1")
    private Long id;

    @NotEmpty
    @Schema(description = "The username of the user", example = "johndoe")
    private String username;

    @NotEmpty
    @Email
    @Schema(description = "The email of the user", example = "johndoe@example.com")
    private String email;

    @NotEmpty
    @Schema(description = "The first name of the user", example = "John")
    private String firstName;

    @NotEmpty
    @Schema(description = "The last name of the user", example = "Doe")
    private String lastName;

    @NotNull
    @Schema(description = "The role of the user", example = "USER")
    private Role role;

    @NotNull
    @Schema(description = "The account associated with the user")
    private Account account;

    @NotNull
    @Schema(description = "The creation timestamp of the user", example = "2024-01-01T12:00:00")
    private Date createdAt;
}
