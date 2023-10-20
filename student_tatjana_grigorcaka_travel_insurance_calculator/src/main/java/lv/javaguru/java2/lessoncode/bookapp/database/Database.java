package lv.javaguru.java2.lessoncode.bookapp.database;

import lv.javaguru.java2.lessoncode.bookapp.domain.Book;

import java.util.List;
import java.util.Optional;

public interface Database {

    void save(Book book);

    boolean deleteById(Long id);

    List<Book> getAllBooks();

    Optional<Book> findBookByTitleAndAuthor(String author, String title);
}
