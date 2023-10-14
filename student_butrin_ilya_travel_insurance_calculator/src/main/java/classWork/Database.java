package classWork;

import java.util.List;

public interface Database {
    List<Book>  getBooks();
    void addBook(Book book);
    void deleteBook(Long id);
}
