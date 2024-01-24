package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateOrderRequestValidator {

	@Autowired private JpaCustomerRepository customerRepository;
	@Autowired private JpaOrderRepository orderRepository;

	public List<CoreError> validate(CreateOrderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateCustomerIdEmpty(request).ifPresent(errors::add);
		validateCustomerIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateCustomerIdEmpty(CreateOrderRequest request) {
		return (request.getCustomerId() == null)
				? Optional.of(new CoreError("customerId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateCustomerIdExistInDb(CreateOrderRequest request) {
		if (request.getCustomerId() != null) {
			Optional<Customer> customerOpt = customerRepository.findById(request.getCustomerId());
			return (customerOpt.isEmpty())
					? Optional.of(new CoreError("customerId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

}







