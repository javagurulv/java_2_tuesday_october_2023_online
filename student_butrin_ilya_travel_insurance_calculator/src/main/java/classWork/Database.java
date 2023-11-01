package classWork;

import java.util.List;

public interface Database {
    List<Book>  getBooks();
    void addBook(Book book);
    boolean deleteBook(Long id);
    boolean repeatBook(String title, String author);
    List <Book> searchByAuthor (String author);
    List <Book> searchByTitle (String title);
    List <Book> searchByAithorandTitle (String author, String title);
}
