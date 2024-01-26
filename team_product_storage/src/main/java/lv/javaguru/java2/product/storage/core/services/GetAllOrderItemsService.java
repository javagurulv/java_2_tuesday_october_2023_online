package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderItemRepository;
import lv.javaguru.java2.product.storage.core.domain.OrderItem;
import lv.javaguru.java2.product.storage.core.requests.GetAllOrderItemsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllOrderItemsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllOrderItemsService {

	@Autowired private JpaOrderItemRepository orderItemRepository;

	public GetAllOrderItemsResponse execute(GetAllOrderItemsRequest request) {
		List<OrderItem> orderItems = orderItemRepository.findAll();
		return new GetAllOrderItemsResponse(orderItems);
	}

}