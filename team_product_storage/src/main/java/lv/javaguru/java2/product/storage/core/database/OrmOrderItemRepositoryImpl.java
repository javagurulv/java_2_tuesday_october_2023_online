package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.domain.OrderItem;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//@Component
//@Transactional
public class OrmOrderItemRepositoryImpl implements OrderItemRepository{

	@Autowired private SessionFactory sessionFactory;

	@Override
	public void save(OrderItem orderItem) {
		sessionFactory.getCurrentSession().save(orderItem);
	}

	@Override
	public Optional<OrderItem> getById(Long id) {
		OrderItem orderItem = sessionFactory.getCurrentSession().get(OrderItem.class, id);
		if (orderItem == null) {
			return Optional.empty();
		} else {
			return Optional.of(orderItem);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete OrderItem where id = :id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result == 1;
	}

	@Override
	public List<OrderItem> getAllOrderItems(Order order) {
		Query<OrderItem> query = sessionFactory.getCurrentSession()
				.createQuery("SELECT oi FROM OrderItem oi where oi.order = :order", OrderItem.class);
		query.setParameter("order", order);
		return query.getResultList();
	}

}
