package lv.javaguru.java2.product.storage.core.database.jpa;

import lv.javaguru.java2.product.storage.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface JpaOrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT SUM(oi.amount) AS total_amount FROM product_storage.orders o INNER JOIN product_storage.order_items oi ON o.id = oi.order_id WHERE oi.order_id = :orderId", nativeQuery = true)
    BigDecimal sumTotalAmount(@Param("orderId") Long id);


}
