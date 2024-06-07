package org.example.demodanya.try2.controllers;

import jakarta.validation.Valid;
import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.AuthorsRequest;
import org.example.demodanya.try2.services.AuthorsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authors")
public class AuthorsController {
    private final AuthorsService authorsService;
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }
    @GetMapping(value = "/{name}")
    public Authors getAuthor(@PathVariable String name) {
        return authorsService.getAuthors(name);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthors(@Valid @RequestBody AuthorsRequest request) {
        authorsService.createAuthors(
                request.name(),
                request.biography(),
                request.birthDate()
        );
    }
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthors(@Valid @RequestBody AuthorsRequest request,@PathVariable String name) {
        authorsService.updateAuthors(
                request.biography(),
                request.birthDate(),
                name
        );
    }
    @DeleteMapping("/{name}")
    public void deleteAuthors(@PathVariable String name) {
        authorsService.deleteAuthors(name);
    }
}
