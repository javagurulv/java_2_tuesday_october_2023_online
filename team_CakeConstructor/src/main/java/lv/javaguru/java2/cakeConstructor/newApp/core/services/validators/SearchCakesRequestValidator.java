package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchCakesRequestValidator {

	public List<CoreError> validate(SearchCakesRequest request) {
		List<CoreError> errors = new ArrayList<>();
		errors.addAll(validateSearchFields(request));
		return errors;
	}

	public List<CoreError> validateSearchFields(SearchCakesRequest request) {
		List<CoreError> errors = new ArrayList<>();
		if (isEmpty(request.getCakeName()) && (request.getWeight() == null )) {
			errors.add(new CoreError("cakeName", "Must not be empty!"));
			errors.add(new CoreError("weight", "Must not be greater than 0.00!"));
		}
		return errors;
	}

	private boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
}
