package lv.javaguru.java2.lessoncode.bookapp.core.database;

import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;

import java.util.List;
import java.util.Optional;

public interface Database {

    void save(Book book);

    boolean deleteById(Long id);

    List<Book> getAllBooks();

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByTitleAndAuthor(String title, String author);

    Optional<Book> findBookByTitleAndAuthor(String author, String title);
}
