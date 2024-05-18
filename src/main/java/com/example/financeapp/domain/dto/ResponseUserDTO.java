package com.example.financeapp.domain.dto;

import java.util.Date;

import com.example.financeapp.domain.entity.Account;
import com.example.financeapp.domain.enums.Role;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "The ID of the user")
    private Long id;

    @Schema(description = "The username of the user")
    private String username;

    @Schema(description = "The email of the user")
    private String email;

    @Schema(description = "The first name of the user")
    private String firstName;

    @Schema(description = "The last name of the user")
    private String lastName;

    @Schema(description = "The role of the user")
    private Role role;

    @Schema(description = "The account associated with the user")
    private Account account;

    @Schema(description = "The creation timestamp of the user")
    private Date createdAt;
}
