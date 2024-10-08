package org.example.demodanya.try2.services;

import jakarta.servlet.http.HttpSession;
import org.example.demodanya.try2.models.*;
import org.example.demodanya.try2.repository.AuthorRepository;
import org.example.demodanya.try2.repository.BookRepository;
import org.example.demodanya.try2.repository.CategoryRepository;
//import org.example.demodanya.try2.utils.MappingUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    //private final MappingUtils mappingUtils;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, HttpSession httpSession) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        //this.mappingUtils = new MappingUtils();
    }

    @Override
    public List<BooksDto> getBooksByTitle(String title) {
        List<Books> allByTitle = bookRepository.findAllByTitle(title);
        List<BooksDto> booksDtoTitle = new ArrayList<>();
        for (Books book : allByTitle) {
            BooksDto booksDto = new BooksDto(book.getId(), book.getTitle(), book.getGenre(), book.getAuthorId());
            booksDtoTitle.add(booksDto);
        }
        return booksDtoTitle;
    }

    @Override
    public List<BooksDto>getBooksByGenre(String genre) {
        List<Books> allByGenre = bookRepository.findAllByGenre(genre);
        List<BooksDto> booksDtoGenre = new ArrayList<>();
        for (Books book : allByGenre) {
            BooksDto booksDto = new BooksDto(book.getId(), book.getTitle(), book.getGenre(), book.getAuthorId());
            booksDtoGenre.add(booksDto);
        }
        return booksDtoGenre;
    }

    @Override
    public List<BooksDto>getBooksByAuthorId(int authorId){
        List<Books> allByAuthorId = bookRepository.findAllByAuthorId(authorId);
        List<BooksDto> booksDtoAuthor = new ArrayList<>();
        for (Books book : allByAuthorId) {
            BooksDto booksDto = new BooksDto(book.getId(), book.getTitle(), book.getGenre(), book.getAuthorId());
            booksDtoAuthor.add(booksDto);
        }
        return booksDtoAuthor;
    }

    @Override
    public List<BooksDto> getBooksByCategoryId(int categoryId){
        Categories category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category with id -" + categoryId + " not found"));
        List<BooksDto> booksDtoCategory = new ArrayList<>();
        List<Books> books = category.getIncludedBooks();
        for (Books book : books) {
            BooksDto booksDto = new BooksDto(book.getId(), book.getTitle(), book.getGenre(), book.getAuthorId());
            booksDtoCategory.add(booksDto);
        }
        return booksDtoCategory;
    }

    @Override
    public List<FullBookInfoProjection> getBooksByGenreAndAuthorBornLater(String genre, Date birthDate){
        return bookRepository.findBooksByGenreAndAuthorBornLater(genre, birthDate);
    }

    @Override
    public List<FullBookInfoProjection> getBooksByPublisher(String name){
        return bookRepository.findBooksByPublisher(name);
    }

    @Override
    public void createBooks(int authorId, String title, String genre, int categoryId) {
        Authors author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author with id -" + authorId + " not found"));
        Categories category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category with id -" + categoryId + " not found"));
        Books book = new Books(title, genre, author.getId());
        book.getCategories().add(category);
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
