package com.example.financeapp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AccountDTO", description = "DTO for representing an account")
public class AccountDTO {
    @NotNull
    @Schema(description = "The ID of the account")
    private Long id;

    @Schema(description = "The id of the user associated with the account")
    private Long user;

    @Schema(description = "The balance of the account")
    private Long balance;

    @Schema(description = "The transaction amount of the account")
    private Long transactionAmount;

    @Schema(description = "The creation timestamp of the account")
    private Date createdAt;

    @Schema(description = "The list of categories associated with the account")
    private List<String> categories;
}
