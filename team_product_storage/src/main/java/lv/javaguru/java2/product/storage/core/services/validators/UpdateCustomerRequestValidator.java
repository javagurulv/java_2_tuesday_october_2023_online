package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.UpdateCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateCustomerRequestValidator {

	public List<CoreError> validate(UpdateCustomerRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateCustomerName(request).ifPresent(errors::add);
		validateRegistrationCode(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateCustomerName(UpdateCustomerRequest request) {
		return (request.getNewCustomerName() == null || request.getNewCustomerName().isEmpty())
			? Optional.of(new CoreError("newCustomerName", "Must not be empty!"))
			: Optional.empty();
	}

	private Optional<CoreError> validateRegistrationCode(UpdateCustomerRequest request) {
		return (request.getNewRegistrationCode() == null || request.getNewRegistrationCode().isEmpty())
				? Optional.of(new CoreError("newRegistrationCode", "Must not be empty!"))
				: Optional.empty();
	}


}
