package lv.javaguru.travel.insurance.database;

import lv.javaguru.travel.insurance.domain.Book;

import java.util.List;

public interface Database {

    void addBook(Book book);
    void deleteBook(Book book);
    List<Book> getAllBooks();
}
