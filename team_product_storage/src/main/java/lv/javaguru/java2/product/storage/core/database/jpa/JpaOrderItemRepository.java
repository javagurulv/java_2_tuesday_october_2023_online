package lv.javaguru.java2.product.storage.core.database.jpa;

import lv.javaguru.java2.product.storage.core.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderItemRepository extends JpaRepository<OrderItem, Long> {

}
