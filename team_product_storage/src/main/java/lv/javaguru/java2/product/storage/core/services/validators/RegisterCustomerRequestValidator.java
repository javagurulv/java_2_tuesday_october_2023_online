package lv.javaguru.java2.product.storage.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.RegisterCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class RegisterCustomerRequestValidator {

	@Autowired private JpaCustomerRepository customerRepository;

	public List<CoreError> validate(RegisterCustomerRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateFirstName(request).ifPresent(errors::add);
		validateLastName(request).ifPresent(errors::add);
		validateDuplicate(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateFirstName(RegisterCustomerRequest request) {
		return (request.getCustomerName() == null || request.getCustomerName().isEmpty())
				? Optional.of(new CoreError("customerName", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateLastName(RegisterCustomerRequest request) {
		return (request.getRegistrationCode() == null || request.getRegistrationCode().isEmpty())
				? Optional.of(new CoreError("registrationCode", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateDuplicate(RegisterCustomerRequest request) {
		List<Customer> customers = customerRepository.findByCustomerNameAndRegistrationCode(request.getCustomerName(), request.getRegistrationCode());
		return (!customers.isEmpty())
				? Optional.of(new CoreError("duplicate", "Duplicate customer not accepted!"))
				: Optional.empty();
	}

}