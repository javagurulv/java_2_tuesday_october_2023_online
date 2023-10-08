package lv.javaguru.travel.insurance;

import java.util.ArrayList;
import java.util.List;

public class DataBook {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        return "DataBook{" +
                "books=" + books +
                '}';
    }
}

