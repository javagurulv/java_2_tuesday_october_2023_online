package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.UpdateCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateCustomerRequestValidator {

	@Autowired private JpaCustomerRepository customerRepository;

	public List<CoreError> validate(UpdateCustomerRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateCustomerIdEmpty(request).ifPresent(errors::add);
		validateCustomerIdExistInDb(request).ifPresent(errors::add);
		validateCustomerName(request).ifPresent(errors::add);
		validateRegistrationCode(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateCustomerIdEmpty(UpdateCustomerRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("customerId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateCustomerIdExistInDb(UpdateCustomerRequest request) {
		if (request.getId() != null) {
			Optional<Customer> readerOpt = customerRepository.findById(request.getId());
			return (readerOpt.isEmpty())
					? Optional.of(new CoreError("customerId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
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
