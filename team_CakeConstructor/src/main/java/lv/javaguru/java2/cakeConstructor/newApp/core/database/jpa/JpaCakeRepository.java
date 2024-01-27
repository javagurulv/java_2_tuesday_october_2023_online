package lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCakeRepository extends JpaRepository<Order, Long> {


}
