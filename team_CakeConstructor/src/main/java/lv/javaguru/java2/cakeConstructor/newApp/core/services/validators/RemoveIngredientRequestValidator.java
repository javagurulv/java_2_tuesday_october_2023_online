package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RemoveIngredientRequestValidator {

	public List<CoreError> validate(RemoveIngredientRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateIngredientId(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateIngredientId(RemoveIngredientRequest request) {
		return (request.getIngredientId() == null)
			? Optional.of(new CoreError("ingredientId", "Must not be empty!"))
			: Optional.empty();
	}

}
