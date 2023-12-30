package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.domain.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrderRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	public Order getById(Long id) {
		return sessionFactory.getCurrentSession()
				.get(Order.class, id);
	}

	public List<Order> getAllOrders(Customer customer) {
		Query<Order> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT o FROM Order o where o.customer = :customer", Order.class);
		query.setParameter("customer", customer);
		return query.getResultList();
	}

}
