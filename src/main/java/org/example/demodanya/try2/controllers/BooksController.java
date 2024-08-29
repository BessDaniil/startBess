package org.example.demodanya.try2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.demodanya.try2.models.*;
import org.example.demodanya.try2.repository.CategoryRepository;
import org.example.demodanya.try2.services.BookService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/books")
@Tag(
        name = "Книги",
        description = "Все методы для работы с книгами"
)
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/by-title/{title}")
    @Operation(summary = "Получить список книг по названию")
    public List<BooksDto> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping(value = "/by-genre/{genre}")
    @Operation(summary = "Получить список книг по жанру")
    public List<BooksDto> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(value = "/by-authorId/{authorId}")
    @Operation(summary = "Получить книг по id автора")
    public List<BooksDto> getBooksByAuthorId(@PathVariable int authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @GetMapping(value = "/by-categoryId/{categoryId}")
    @Operation(summary = "Получить список книг по ID категории")
    public List<BooksDto> getBooksByCategoryId(@PathVariable int categoryId) {
        return bookService.getBooksByCategoryId(categoryId);
    }

    @GetMapping(value = "/genre/{genre}/birthDate/{birthDate}")
    @Operation(summary = "Получить список книг с информацией об их категориях по жанру и автор которых родился после указанной даты")
    public List<FullBookInfoProjection> getBooksByGenreAndBirthDate(@PathVariable String genre, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate) {
        return bookService.getBooksByGenreAndAuthorBornLater(genre, birthDate);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавить книгу")
    public void createBookWithAuthorId(@Valid @RequestBody BooksRequest request) {
        bookService.createBooks(
                request.authorId(),
                request.genre(),
                request.title(),
                request.categoryId()
        );
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Изменить информацию о книге")
    public void updateBook(@Valid @RequestBody BooksRequest request, @PathVariable int id) {
        bookService.updateBooks(
                request.title(),
                request.genre(),
                request.authorId(),
                id
        );
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удалить книгу")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBooks(id);
    }
}
