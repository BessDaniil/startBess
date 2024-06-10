package org.example.demodanya.try2.services;

import org.example.demodanya.try2.models.Authors;
import org.example.demodanya.try2.models.Books;
import org.example.demodanya.try2.repository.AuthorRepository;
import org.example.demodanya.try2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Books> getBooksByTitle(String title) {
        return bookRepository.findAllByTitle(title);
    }

    @Override
    public List<Books>getBooksByGenre(String genre) {
        return bookRepository.findAllByGenre(genre);
    }

    @Override
    public List<Books>getBooksByAuthorId(int authorId){
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Override
    public void createBooks(int authorId, String title, String genre) {
        Authors author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author with id -" + authorId + " not found"));
        int authorOfBook = author.getId();
        Books book = new Books(title, genre, authorOfBook);
        bookRepository.save(book);
    }

    @Override
    public void updateBooks(String title, String genre, int authorId, int id){
        Books book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book with id -" + id + " not found"));
        book.setGenre(genre);
        book.setAuthorId(authorId);
        book.setTitle(title);
        bookRepository.save(book);
    }

    @Override
    public void deleteBooks(int id){
        Books book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book with id -" + id + " not found"));
        bookRepository.delete(book);
    }


}
