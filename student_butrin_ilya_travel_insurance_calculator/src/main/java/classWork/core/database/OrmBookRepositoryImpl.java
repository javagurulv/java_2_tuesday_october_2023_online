package classWork.core.database;

import classWork.domen.Book;
import classWork.core.database.BookRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Component
@Transactional
public class OrmBookRepositoryImpl implements BookRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public List<Book> getBooks() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    @Override
    public boolean deleteBook(Long id) {

            Query query = sessionFactory.getCurrentSession().createQuery(
                    "delete Book where id = :id");
            query.setParameter("id", id);
            int result = query.executeUpdate();
            return result == 1;
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
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Book b where author = :author");
        query.setParameter("author", author);
        return query.getResultList();
    }

    @Override
    public List<Book> searchByTitle(String title) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Book b where title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public List<Book> searchByAithorandTitle(String author, String title) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "select b FROM Book b where title = : title AND author = :author");
        query.setParameter("title", title);
        query.setParameter("author", author);
        return query.getResultList();
    }
    }
