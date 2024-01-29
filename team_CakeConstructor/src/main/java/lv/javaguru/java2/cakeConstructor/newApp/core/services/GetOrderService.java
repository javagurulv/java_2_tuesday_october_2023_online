package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetOrderRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetOrderResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.GetOrderValidator;
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