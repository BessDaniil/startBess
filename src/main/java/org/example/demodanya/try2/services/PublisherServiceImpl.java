package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.models.Publisher;
import org.example.demodanya.try2.repository.BookRepository;
import org.example.demodanya.try2.repository.PublisherRepository;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void createPublisher(String name, String address, String phoneNumber, int bookId) {
        Publisher publisher = new Publisher(name, address, phoneNumber);
        Books book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book with id -" + bookId + " not found"));
        publisher.getBooks().add(book);
        publisherRepository.save(publisher);
    }
}
