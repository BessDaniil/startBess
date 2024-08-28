package org.example.demodanya.try2.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.demodanya.try2.models.Categories;
import org.example.demodanya.try2.models.CategoriesRequest;
import org.example.demodanya.try2.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
@Tag(
        name = "Категории",
        description = "Все методы для работы с категориями"
)
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавить категорию")
    public void addCategory(@Valid @RequestBody CategoriesRequest request) {
        categoryService.addCategory(
                request.name()
        );
    }
}
