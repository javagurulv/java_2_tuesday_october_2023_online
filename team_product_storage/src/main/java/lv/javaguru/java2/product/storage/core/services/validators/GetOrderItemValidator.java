package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.GetOrderItemRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetOrderItemValidator {

	public List<CoreError> validate(GetOrderItemRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(GetOrderItemRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("id", "Must not be empty!"))
				: Optional.empty();
	}

}