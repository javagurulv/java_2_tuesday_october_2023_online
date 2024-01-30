package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetWeightRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetWeightRequestValidator {

	@Autowired private JpaCakeRepository cakeRepository;
	@Autowired private JpaIngredientRepository ingredientRepository;
	@Autowired private JpaCakeIngredientRepository cakeIngredientRepository;

	public List<CoreError> validate(GetWeightRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateCakeIdEmpty(request).ifPresent(errors::add);
		validateCakeIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateCakeIdEmpty(GetWeightRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("cakeId", "Must not be empty!"))
				: Optional.empty();
	}


	private Optional<CoreError> validateCakeIdExistInDb(GetWeightRequest request) {
		if (request.getId() != null) {
			Optional<Cake> cakeOpt = cakeRepository.findById(request.getId());
			return (cakeOpt.isEmpty())
					? Optional.of(new CoreError("cakeId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}


}
