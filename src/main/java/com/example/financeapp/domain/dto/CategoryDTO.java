package com.example.financeapp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "DTO representing a category")
public class CategoryDTO {
    @NotNull
    @Schema(description = "The ID of the category")
    private Long id;

    @NotNull
    @Schema(description = "The name of the category")
    private String categoryName;

    @Schema(description = "The description of the category")
    private String description;

    @NotNull
    @Schema(description = "The id of account associated with the category")
    private Long accountId;

    @NotNull
    @Schema(description = "List of transactions associated with the category")
    private List<TransactionDTO> transactions;

    @NotNull
    @Schema(description = "The creation timestamp of the category")
    private Date createdAt;
}
