package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.IngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.GetIngredientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetIngredientService {

	@Autowired private IngredientRepository ingredientRepository;
	@Autowired private GetIngredientValidator validator;

	public GetIngredientResponse execute(GetIngredientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetIngredientResponse(errors);
		}
		return ingredientRepository.getById(request.getId())
				.map(GetIngredientResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetIngredientResponse(errors);
				});
	}

}