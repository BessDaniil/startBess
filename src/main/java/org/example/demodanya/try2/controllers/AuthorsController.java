package org.example.demodanya.try2.controllers;

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
public class AuthorsController {
    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping(value = "/{name}")
    public List<Authors> getAuthor(@PathVariable String name) {
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

    @PutMapping(value = "/update/{id}")
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
    public void deleteAuthors(@PathVariable int id) {
        authorsService.deleteAuthors(id);
    }

    @GetMapping("/by-id/{id}")
    public Authors getAuthorByName(@PathVariable int id) {
        return authorsService.getAuthorById(id);
    }

//    @PutMapping("/{name}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateAuthors(@Valid @RequestBody AuthorsRequest request, @PathVariable String name) {
//        authorsService.updateAuthors(
//                request.biography(),
//                request.birthDate(),
//                name
//        );
//    }
//
//    @DeleteMapping("/{name}")
//    public void deleteAuthors(@PathVariable String name) {
//        authorsService.deleteAuthors(name);
//    }
}
