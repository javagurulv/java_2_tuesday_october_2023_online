package lessoncode.database;

import lessoncode.domain.Book;

import java.util.List;
import java.util.Optional;

public interface Database {

    void addBook(Book book);

    void deleteBook(Book book);

    List<Book> getAllBooks();

    Optional<Book> findBookByTitleAndAuthor(String author, String title);
}
