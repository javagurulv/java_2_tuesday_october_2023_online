package lv.javaguru.travel.insurance;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database{
    private List<Book> books = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

}
