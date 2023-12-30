package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.domain.OrderItem;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrderItemRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(OrderItem orderItem) {
		sessionFactory.getCurrentSession().save(orderItem);
	}

	public OrderItem getById(Long id) {
		return sessionFactory.getCurrentSession()
				.get(OrderItem.class, id);
	}

	public List<OrderItem> getAllOrderItems(Order order) {
		Query<OrderItem> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT oi FROM OrderItem oi where oi.order = :order", OrderItem.class);
		query.setParameter("order", order);
		return query.getResultList();
	}

}
