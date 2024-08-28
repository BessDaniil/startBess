package org.example.demodanya.try2.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

@Data
public class BooksDto {
    private int id;
    private String title;
    private String genre;
    private int authorId;

    public BooksDto(int id, String title, String genre, int authorId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }
}
//public enum BookDto{;
//        public interface Id{
//            @NotNull
//            int getId();
//        }
//        public interface Title{
//            @NotNull
//            String getTitle();
//        }
//        public interface Genre{
//            @NotNull
//            String getGenre();
//        }
//        public interface AuthorId{
//            @NotNull
//            int getAuthorId();
//        }
//    }
//    public enum Request{;
//        @Value public static class GetBooksByTitle implements BookDto.Id, BookDto.Title, BookDto.Genre, BookDto.AuthorId {
//            int id;
//            String title;
//            String genre;
//            int authorId;
//        }
//    }
//    public enum Response {;
//        @Value public static class Public implements BookDto.Title, BookDto.Genre,  BookDto.AuthorId {
//            String title;
//            String genre;
//            int authorId;
//        }
//        @Value private static class Private implements BookDto.Id, BookDto.Title, BookDto.Genre, BookDto.AuthorId {
//            int id;
//            String title;
//            String genre;
//            int authorId;
//        }
//    }
