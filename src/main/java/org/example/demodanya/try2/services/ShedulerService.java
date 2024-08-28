package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Books;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
@EnableScheduling
public class ShedulerService {
    static final Logger LOGGER = Logger.getLogger(ShedulerService.class.getName());
    private List <Books> books;

    public List<Books> getBooks() {
        return books = new ArrayList<Books>();
    }
    @Scheduled(cron = "@daily")
    public void scheduled() throws InterruptedException {
        List<Books> books = this.getBooks();

    }
}
