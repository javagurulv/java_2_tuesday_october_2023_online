package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmReaderBookRepositoryImpl implements ReaderBookRepository{

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(ReaderBook readerBook) {
		sessionFactory.getCurrentSession().save(readerBook);
	}

	@Override
	public Optional<ReaderBook> getById(Long id) {
		ReaderBook readerBook = sessionFactory.getCurrentSession().get(ReaderBook.class, id);
		if (readerBook == null) {
			return Optional.empty();
		} else {
			return Optional.of(readerBook);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete ReaderBook where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<ReaderBook> getAllReaderBooks(Reader reader) {
		Query<ReaderBook> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT rb FROM ReaderBook rb where rb.reader = :reader", ReaderBook.class);
		query.setParameter("reader", reader);
		return query.getResultList();
	}

}
