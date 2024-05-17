package com.example.financeapp.controller;

import com.example.financeapp.domain.dto.CategoryDTO;
import com.example.financeapp.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Categories")
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all user categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/{categoryId}")
    @Operation(summary = "Get a category by its ID")
    public CategoryDTO getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public CategoryDTO createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @PutMapping("/{categoryId}")
    @Operation(summary = "Update an existing category")
    public CategoryDTO updateCategory(@RequestBody @Valid CategoryDTO categoryDTO, @PathVariable Long categoryId) {
        return categoryService.updateCategory(categoryId, categoryDTO);
    }

    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete a category by its ID")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
