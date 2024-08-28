package org.example.demodanya.try2.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CategoriesRequest(
        @NotNull
        String name
) {
}
