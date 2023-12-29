package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.domain.ReaderBook;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ReaderBookRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(ReaderBook readerBook) {
		sessionFactory.getCurrentSession().save(readerBook);
	}

	public ReaderBook getById(Long id) {
		return sessionFactory.getCurrentSession()
				.get(ReaderBook.class, id);
	}

	public List<ReaderBook> getAllReaderBooks(Reader reader) {
		Query<ReaderBook> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT rb FROM ReaderBook rb where rb.reader = :reader", ReaderBook.class);
		query.setParameter("reader", reader);
		return query.getResultList();
	}

}
