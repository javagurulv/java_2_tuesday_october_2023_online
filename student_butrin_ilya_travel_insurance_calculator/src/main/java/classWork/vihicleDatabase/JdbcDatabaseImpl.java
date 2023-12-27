package classWork.vihicleDatabase;

import classWork.Book;
import classWork.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class JdbcDatabaseImpl implements Database {
    @Autowired private JdbcTemplate jdbcTemplate;
    @Override
    public void addBook(Book book) {
        jdbcTemplate.update(
                "INSERT INTO books (title, author) "
                        + "VALUES (?, ?)",
                book.getTitle(), book.getAuthor()
        );
    }

    @Override
    public List<Book> getBooks() {
        String sql = "SELECT * FROM books";
        return jdbcTemplate.query(sql, new BookRowMapper());
        }

    @Override
    public boolean deleteBook(Long id) {
        return jdbcTemplate.update( "DELETE FROM books WHERE id = ?", id) == 1;
    }

    @Override
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
    public List<Book> searchByAuthor(String author) {
        String sql = "Select * from books" + "where author = ?";
        Object[] args = new Object[] {author};
        return jdbcTemplate.query(sql, args, new BookRowMapper());

    }

    @Override
    public List<Book> searchByTitle(String title) {
       String sql = "SELECT * FROM books where title = ?";
       Object[] args = new Object[] {title};
       return jdbcTemplate.query(sql, args, new BookRowMapper());
    }

    @Override
    public List<Book> searchByAithorandTitle(String author, String title) {
        String sql = "SELECT * FROM books where author = ? and title = ?";
        Object[] args = new Object[] {author , title};
        return  jdbcTemplate.query(sql,args,new BookRowMapper());
    }
}