package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmCustomerRepositoryImpl implements CustomerRepository {

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public Customer findById(Long id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public Optional<Customer> getById(Long id) {
		Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
		if (customer == null) {
			return Optional.empty();
		} else {
			return Optional.of(customer);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Customer where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession()
				.createQuery("SELECT c FROM Customer c", Customer.class)
				.getResultList();
	}

	@Override
	public List<Customer> findByCustomerName(String customerName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Customer c where customerName = :customerName");
		query.setParameter("customerName", customerName);
		return query.getResultList();
	}

	@Override
	public List<Customer> findByRegistrationCode(String registrationCode) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Customer c where registrationCode = :registrationCode");
		query.setParameter("registrationCode", registrationCode);
		return query.getResultList();
	}

	@Override
	public List<Customer> findByCustomerNameAndRegistrationCode(String customerName, String registrationCode) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select c FROM Customer c where customerName = : customerName AND registrationCode = :registrationCode");
		query.setParameter("customerName", customerName);
		query.setParameter("registrationCode", registrationCode);
		return query.getResultList();
	}


}