package org.example.demodanya.try2.models;

import java.util.UUID;

public record Books(UUID id, String title, String genre, UUID author_id) {}
