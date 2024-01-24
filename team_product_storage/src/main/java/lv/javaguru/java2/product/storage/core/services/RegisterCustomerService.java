package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.RegisterCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.RegisterCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RegisterCustomerRequestValidator;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RegisterCustomerService {

	@Autowired private JpaCustomerRepository customerRepository;
	@Autowired private RegisterCustomerRequestValidator validator;

	public RegisterCustomerResponse execute(RegisterCustomerRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new RegisterCustomerResponse(errors);
		}

		Customer customer = new Customer(request.getCustomerName(), request.getRegistrationCode());
		customerRepository.save(customer);

		return new RegisterCustomerResponse(customer);
	}

}