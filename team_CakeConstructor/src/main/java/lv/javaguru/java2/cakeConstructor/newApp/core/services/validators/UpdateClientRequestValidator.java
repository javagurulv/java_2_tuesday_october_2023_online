package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateClientRequestValidator {

	public List<CoreError> validate(UpdateClientRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateFirstName(request).ifPresent(errors::add);
		validateLastName(request).ifPresent(errors::add);
		validatePersonalCode(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateFirstName(UpdateClientRequest request) {
		return (request.getNewFirstName() == null || request.getNewFirstName().isEmpty())
			? Optional.of(new CoreError("newFirstName", "Must not be empty!"))
			: Optional.empty();
	}

	private Optional<CoreError> validateLastName(UpdateClientRequest request) {
		return (request.getNewLastName() == null || request.getNewLastName().isEmpty())
				? Optional.of(new CoreError("newLastName", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validatePersonalCode(UpdateClientRequest request) {
		return (request.getNewPersonalCode() == null || request.getNewPersonalCode().isEmpty())
				? Optional.of(new CoreError("newPersonalCode", "Must not be empty!"))
				: Optional.empty();
	}

}
