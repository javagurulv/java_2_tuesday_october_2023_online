package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmOrderRepositoryImpl implements OrderRepository{

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public Order findById(Long id) {
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public Optional<Order> getById(Long id) {
		Order order = sessionFactory.getCurrentSession().get(Order.class, id);
		if (order == null) {
			return Optional.empty();
		} else {
			return Optional.of(order);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Order where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<Order> getAllOrders(Client client) {
		Query<Order> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT o FROM Order o where o.client = :client", Order.class);
		query.setParameter("client", client);
		return query.getResultList();
	}

}
