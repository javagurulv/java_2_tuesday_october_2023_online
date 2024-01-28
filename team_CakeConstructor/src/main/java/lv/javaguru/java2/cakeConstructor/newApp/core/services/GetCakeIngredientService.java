package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetCakeIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetCakeIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.GetCakeIngredientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetCakeIngredientService {

	@Autowired private JpaCakeIngredientRepository cakeIngredientRepository;
	@Autowired private GetCakeIngredientValidator validator;

	public GetCakeIngredientResponse execute(GetCakeIngredientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetCakeIngredientResponse(errors);
		}
		return cakeIngredientRepository.findById(request.getId())
				.map(GetCakeIngredientResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetCakeIngredientResponse(errors);
				});
	}

}