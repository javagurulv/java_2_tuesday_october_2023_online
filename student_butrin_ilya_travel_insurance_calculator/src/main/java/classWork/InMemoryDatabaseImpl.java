package classWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean deleteBook(Long id) {
        boolean rez = false;
        for (int i = 0; i < getBooks().size(); i++)
            if (getBooks().get(i).getId().equals(id)) {
                books.remove(getBooks().get(i));
                rez = true;
                break;
            }
        return rez;
    }

    public boolean repeatBook(String title, String author) {
        List<Book> allbook = getBooks();
        boolean rezult = false;
        for (Book book : allbook) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                rezult = true;
            }
        }
        return rezult;
    }

    @Override
    public String toString() {
        return "DataBook{" +
                "books=" + books +
                '}';
    }
}

