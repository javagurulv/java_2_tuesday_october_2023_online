package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateIngredientRequestValidator {

	public List<CoreError> validate(UpdateIngredientRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateType(request).ifPresent(errors::add);
		validateTaste(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateType(UpdateIngredientRequest request) {
		return (request.getNewType() == null || request.getNewType().isEmpty())
			? Optional.of(new CoreError("newType", "Must not be empty!"))
			: Optional.empty();
	}

	private Optional<CoreError> validateTaste(UpdateIngredientRequest request) {
		return (request.getNewTaste() == null || request.getNewTaste().isEmpty())
				? Optional.of(new CoreError("newTaste", "Must not be empty!"))
				: Optional.empty();
	}

}
