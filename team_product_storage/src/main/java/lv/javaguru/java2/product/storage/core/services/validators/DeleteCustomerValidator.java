package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.DeleteCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeleteCustomerValidator {

	@Autowired private JpaCustomerRepository customerRepository;

	public List<CoreError> validate(DeleteCustomerRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		validateIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(DeleteCustomerRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("customerId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateIdExistInDb(DeleteCustomerRequest request) {
		if (request.getId() != null) {
			Optional<Customer> customerOpt = customerRepository.findById(request.getId());
			return (customerOpt.isEmpty())
					? Optional.of(new CoreError("customerId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

}