package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Publisher;

public interface PublisherService {
    void createPublisher(String name, String address, String phoneNumber, int bookId);
}
