package org.example.demodanya.try2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.AuthorsRequest;
import org.example.demodanya.try2.services.AuthorsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/authors")
@Tag(
        name = "Авторы",
        description = "Все методы для работы с авторами"
)
public class AuthorsController {
    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping(value = "/{name}")
    @Operation(summary = "Получить список авторов по имени")
    public List<Authors> getAuthor(@PathVariable String name) {
        return authorsService.getAuthors(name);
    }

    @PostMapping
    @Operation(summary = "Добавить автора")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthors(@Valid @RequestBody AuthorsRequest request) {
        authorsService.createAuthors(
                request.name(),
                request.biography(),
                request.birthDate()
        );
    }

    @PutMapping(value = "/update/{id}")
    @Operation(summary = "Обновить информацию об авторе")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthors(@Valid @RequestBody AuthorsRequest request, @PathVariable int id) {
        authorsService.updateAuthors(
                request.name(),
                request.biography(),
                request.birthDate(),
                id
        );
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удалить автора")
    public void deleteAuthors(@PathVariable int id) {
        authorsService.deleteAuthors(id);
    }

    @GetMapping("/by-id/{id}")
    @Operation(hidden = true)
    public Authors getAuthorByName(@PathVariable int id) {
        return authorsService.getAuthorById(id);
    }
}
