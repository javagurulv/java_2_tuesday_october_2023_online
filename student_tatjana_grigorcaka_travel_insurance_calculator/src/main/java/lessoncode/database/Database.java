package lessoncode.database;

import lessoncode.domain.Book;

import java.util.List;

public interface Database {

    void addBook(Book book);
    void deleteBook(Book book);
    List<Book> getAllBooks();
}
