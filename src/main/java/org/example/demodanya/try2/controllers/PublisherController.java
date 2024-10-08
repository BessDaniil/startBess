package org.example.demodanya.try2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.example.demodanya.try2.models.PublisherRequest;
import org.example.demodanya.try2.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/publisher")
@Tag(
        name = "Издатели",
        description = "Все методы для работы с издателями"
)
public class PublisherController {

    private final PublisherService publisherService;
    public PublisherController(PublisherService publisherService){this.publisherService = publisherService;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавить издателя")
    public void createPublisher(@Valid @RequestBody PublisherRequest request) {
        publisherService.createPublisher(
                request.name(),
                request.address(),
                request.phoneNumber(),
                request.bookId()
        );
    }
}
