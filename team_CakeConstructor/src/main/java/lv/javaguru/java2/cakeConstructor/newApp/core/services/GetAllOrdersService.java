package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllOrdersRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllOrdersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllOrdersService {
    @Autowired private JpaOrderRepository orderRepository;

    public GetAllOrdersResponse execute(GetAllOrdersRequest request) {
        List<Order> orders = orderRepository.findAll();
        return new GetAllOrdersResponse(orders);
    }
}
