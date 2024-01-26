package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    void save(Order order);

    Order findById(Long id);

    Optional<Order> getById(Long id);

    boolean deleteById(Long id);

    List<Order> getAllOrders(Customer customer);


}



