package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.IngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.DeleteIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.DeleteIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.DeleteIngredientValidator;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteIngredientService {

	@Autowired private IngredientRepository ingredientRepository;
	@Autowired private DeleteIngredientValidator validator;

	public DeleteIngredientResponse execute(DeleteIngredientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new DeleteIngredientResponse(errors);
		}
		return ingredientRepository.getById(request.getId())
				.map(ingredient -> {
					ingredientRepository.deleteById(request.getId());
					return new DeleteIngredientResponse(ingredient);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new DeleteIngredientResponse(errors);
				});
	}

}