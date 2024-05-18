package com.example.financeapp.domain.dto;

import com.example.financeapp.domain.entity.Category;
import com.example.financeapp.domain.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Schema(name = "TransactionDTO", description = "DTO for Transaction entity")
public class ResponseTransactionDTO {
    @NotNull
    @Schema(description = "The ID of the transaction", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Value of the transaction", example = "1000")
    private Long value;

    @NotNull
    @Schema(description = "Type of the transaction", example = "INCOME")
    private TransactionType type;

    @Schema(description = "Description of the transaction", example = "Salary")
    private String description;

    @NotNull
    @Schema(description = "Category of the transaction")
    private Category category;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Date of the transaction", example = "2024-05-16")
    private Date date;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @Schema(description = "Creation date of the transaction", example = "2024-01-01T12:00:00.000+0000")
    private Date createdAt;
}
