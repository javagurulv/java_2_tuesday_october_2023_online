package classWork;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {
    List<Book> books = new ArrayList<>();
    Long id = 1l;

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(id);
        id++;
        books.add(book);
    }

    public void deleteBook(Long id) {
        for (int i = 0; i < getBooks().size(); i++) {
            if (getBooks().get(i).getId().equals(id)) {
                books.remove(getBooks().get(i));
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "DataBook{" +
                "books=" + books +
                '}';
    }
}

