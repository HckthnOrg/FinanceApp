package com.example.financeapp.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representing a category")
public class CategoryDTO {
    @NotNull
    @Schema(description = "The name of the category")
    private String categoryName;

    @Schema(description = "The description of the category")
    private String description;
}
