package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderItemRepository;
import lv.javaguru.java2.product.storage.core.requests.GetOrderItemRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.GetOrderItemResponse;
import lv.javaguru.java2.product.storage.core.services.validators.GetOrderItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetOrderItemService {

	@Autowired private JpaOrderItemRepository orderItemRepository;
	@Autowired private GetOrderItemValidator validator;

	public GetOrderItemResponse execute(GetOrderItemRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetOrderItemResponse(errors);
		}
		return orderItemRepository.findById(request.getId())
				.map(GetOrderItemResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetOrderItemResponse(errors);
				});
	}

}