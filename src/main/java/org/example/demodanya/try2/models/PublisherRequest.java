package org.example.demodanya.try2.models;

import jakarta.validation.constraints.NotNull;

public record PublisherRequest(
        @NotNull
        String name,
        @NotNull
        String address,
        @NotNull
        String phoneNumber,
        @NotNull
        int bookId
) {

}
