package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientToCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddIngredientToCakeRequestValidator {

	@Autowired private JpaIngredientRepository ingredientRepository;
	@Autowired private JpaCakeRepository cakeRepository;
	@Autowired private JpaCakeIngredientRepository cakeIngredientRepository;

	public List<CoreError> validate(AddIngredientToCakeRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateCakeIdEmpty(request).ifPresent(errors::add);
		validateIngredientIdEmpty(request).ifPresent(errors::add);
		validateQuantityEmpty(request).ifPresent(errors::add);
		validateCakeIdExistInDb(request).ifPresent(errors::add);
		validateIngredientIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateCakeIdEmpty(AddIngredientToCakeRequest request) {
		return (request.getCakeId() == null)
				? Optional.of(new CoreError("cakeId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateIngredientIdEmpty(AddIngredientToCakeRequest request) {
		return (request.getIngredientId() == null)
				? Optional.of(new CoreError("ingredientId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateQuantityEmpty(AddIngredientToCakeRequest request) {
		return (request.getQuantity() == 0.00)
				? Optional.of(new CoreError("quantity", "Must be greater than 0!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateCakeIdExistInDb(AddIngredientToCakeRequest request) {
		if (request.getCakeId() != null) {
			Optional<Cake> cakeOpt = cakeRepository.findById(request.getCakeId());
			return (cakeOpt.isEmpty())
					? Optional.of(new CoreError("cakeId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateIngredientIdExistInDb(AddIngredientToCakeRequest request) {
		if (request.getIngredientId() != null) {
			Optional<Ingredient> ingredientOpt = ingredientRepository.findById(request.getIngredientId());
			return (ingredientOpt.isEmpty())
					? Optional.of(new CoreError("ingredientId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}


}







