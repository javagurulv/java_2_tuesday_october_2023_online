package lv.javaguru.java2.lessoncode.book.app.core.database;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrmReaderRepositoryImpl implements ReaderRepository {

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(Reader reader) {
		sessionFactory.getCurrentSession().save(reader);
	}

	@Override
	public Reader findById(Long id) { return sessionFactory.getCurrentSession().get(Reader.class, id); }

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Reader where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Reader> getAllReaders() {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT r FROM Reader r", Reader.class)
				.getResultList();
	}

	@Override
	public List<Reader> findByFirstName(String firstName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r FROM Reader r where firstName = :firstName");
		query.setParameter("firstName", firstName);
		return query.getResultList();
	}

	@Override
	public List<Reader> findByLastName(String lastName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r FROM Reader r where lastName = :lastName");
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}


	@Override
	public List<Reader> findByPersonalCode(String personalCode) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r FROM Reader r where personalCode = :personalCode");
		query.setParameter("personalCode", personalCode);
		return query.getResultList();
	}

	@Override
	public List<Reader> findByFirstNameAndLastName(String firstName, String lastName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r FROM Reader r where firstName = : firstName AND lastName = :lastName");
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	public List<Reader> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String personalCode) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select r FROM Reader r where firstName = : firstName AND lastName = :lastName AND personalCode = :personalCode");
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		query.setParameter("personalCode", personalCode);
		return query.getResultList();
	}

}