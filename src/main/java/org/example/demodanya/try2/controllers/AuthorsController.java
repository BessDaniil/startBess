package org.example.demodanya.try2.controllers;

import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.service.AuthorsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/authors")
public class AuthorsController {
    private final AuthorsService authorsService;
    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }
    @GetMapping(value = "/id:\\d+")
    public Authors getAuthor(@PathVariable int id) {
        return authorsService.getAuthors(id);
    }
}
