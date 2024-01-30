package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void save(Order order);

    Optional<Order> getById(Long id);

    boolean deleteById(Long id);

    List<Order> getAllOrders(Client client);
}
