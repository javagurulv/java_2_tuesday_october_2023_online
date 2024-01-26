package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.domain.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository {

    void save(OrderItem orderItem);

    Optional<OrderItem> getById(Long id);

    boolean deleteById(Long id);

    List<OrderItem> getAllOrderItems(Order order);


}



