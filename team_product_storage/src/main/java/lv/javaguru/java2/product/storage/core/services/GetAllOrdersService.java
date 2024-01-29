package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.domain.Order;
import lv.javaguru.java2.product.storage.core.requests.GetAllOrdersRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllOrdersResponse;
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