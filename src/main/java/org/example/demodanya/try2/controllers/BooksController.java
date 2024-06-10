package org.example.demodanya.try2.controllers;

import jakarta.validation.Valid;
import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.models.BooksRequest;
import org.example.demodanya.try2.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

    private final BookService bookService;
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/by-title/{title}")
    public List<Books> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping(value = "/by-genre/{genre}")
    public List<Books> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(value = "/by-authorId/{authorId}")
    public List<Books> getBooksByAuthorId(@PathVariable int authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBookWithAuthorId(@Valid @RequestBody BooksRequest request) {
        bookService.createBooks(
                request.authorId(),
                request.genre(),
                request.title()
        );
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@Valid @RequestBody BooksRequest request, @PathVariable int id) {
        bookService.updateBooks(
                request.title(),
                request.genre(),
                request.authorId(),
                id
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBooks(id);
    }
}
