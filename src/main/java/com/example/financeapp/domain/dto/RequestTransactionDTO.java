package com.example.financeapp.domain.dto;

import com.example.financeapp.domain.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Schema(name = "TransactionDTO", description = "DTO for Transaction entity")
public class RequestTransactionDTO {
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
    private String categoryName;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Date of the transaction", example = "2024-05-16")
    private Date date;
}
