package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.IngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.UpdateIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.UpdateIngredientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateIngredientService {

	@Autowired private IngredientRepository ingredientRepository;
	@Autowired private UpdateIngredientRequestValidator validator;

	public UpdateIngredientResponse execute(UpdateIngredientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateIngredientResponse(errors);
		}

		return ingredientRepository.getById(request.getId())
				.map(ingredient -> {
					ingredient.setType(request.getNewType());
					ingredient.setTaste(request.getNewTaste());
					return new UpdateIngredientResponse(ingredient);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateIngredientResponse(errors);
				});
	}

}