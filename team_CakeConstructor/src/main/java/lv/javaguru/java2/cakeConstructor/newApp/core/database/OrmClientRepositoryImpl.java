package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrmClientRepositoryImpl implements ClientRepository {

	@Autowired private SessionFactory sessionFactory;
	@Override
	public void save(Client client) {
		sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public Client findById(Long id) { return sessionFactory.getCurrentSession().get(Client.class, id); }

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Client where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Client> getAllClients() {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT c FROM Client c", Client.class)
				.getResultList();
	}

	@Override
	public List<Client> findByFirstName(String firstName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Client c where firstName = :firstName");
		query.setParameter("firstName", firstName);
		return query.getResultList();
	}

	@Override
	public List<Client> findByLastName(String lastName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Client c where lastName = :lastName");
		query.setParameter("lastName", lastName);
		return query.getResultList();
	}

	@Override
	public List<Client> findByPersonalCode(String personalCode) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Client c where personalCode = :personalCode");
		query.setParameter("personalCode", personalCode);
		return query.getResultList();
	}

	@Override
	public List<Client> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String personalCode) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Client c where firstName = : firstName AND lastName = : lastName AND personalCode = :personalCode");
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		query.setParameter("personalCode", personalCode);
		return query.getResultList();
	}


}