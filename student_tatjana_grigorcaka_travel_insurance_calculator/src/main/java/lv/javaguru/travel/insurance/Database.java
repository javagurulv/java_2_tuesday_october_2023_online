package lv.javaguru.travel.insurance;

import java.util.List;

public interface Database {

    void addBook(Book book);
    void deleteBook(Book book);
    List<Book> getAllBooks();
}
