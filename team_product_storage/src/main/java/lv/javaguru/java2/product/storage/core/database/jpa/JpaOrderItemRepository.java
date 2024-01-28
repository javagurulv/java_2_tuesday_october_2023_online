package lv.javaguru.java2.product.storage.core.database.jpa;

import lv.javaguru.java2.product.storage.core.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface JpaOrderItemRepository extends JpaRepository<OrderItem, Long> {

   @Query(value = "SELECT price * :quantity AS amount FROM product_storage.products p WHERE p.id = :productId", nativeQuery = true)
   BigDecimal multiplyAmount(@Param("productId") Long productId,
                             @Param("quantity") Integer quantity);


}
