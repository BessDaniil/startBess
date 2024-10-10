package org.example.demodanya.try2.config;

import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Timestamp;
import java.util.List;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {
    private static final Logger log = LoggerFactory.getLogger(SchedulerConfig.class);
    private final BookRepository bookRepository;

    public SchedulerConfig(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Scheduled(cron = "*/10 * * * * *")//"0 0 9 * * *"
    public void getBooksOfDay() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis() - 86400000);
        List<Books> booksOfDay = bookRepository.findAllByCreateDateGreaterThan(timestamp);
        StringBuilder books = new StringBuilder();
        for (Books book : booksOfDay) {
            books.append(book.toString()).append("\n");
        }
        log.info("Книги, добавленные за день " + books);
    }
}
