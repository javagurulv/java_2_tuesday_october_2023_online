package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    boolean deleteById(Long id);

    List<Book> getAllBooks();

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByTitleAndAuthor(String title, String author);

}
