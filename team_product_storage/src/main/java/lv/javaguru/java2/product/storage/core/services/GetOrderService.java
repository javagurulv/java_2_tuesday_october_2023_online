package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.services.validators.GetOrderValidator;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.requests.GetOrderRequest;
import lv.javaguru.java2.product.storage.core.responses.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetOrderService {

	@Autowired private JpaOrderRepository orderRepository;
	@Autowired private GetOrderValidator validator;

	public GetOrderResponse execute(GetOrderRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetOrderResponse(errors);
		}
		return orderRepository.findById(request.getId())
				.map(GetOrderResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetOrderResponse(errors);
				});
	}

}