package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.CustomerRepository;
import lv.javaguru.java2.product.storage.core.requests.UpdateCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.UpdateCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.validators.UpdateCustomerRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateCustomerService {

	@Autowired private CustomerRepository customerRepository;
	@Autowired private UpdateCustomerRequestValidator validator;

	public UpdateCustomerResponse execute(UpdateCustomerRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateCustomerResponse(errors);
		}

		return customerRepository.getById(request.getId())
				.map(customer -> {
					customer.setCustomerName(request.getNewCustomerName());
					customer.setRegistrationCode(request.getNewRegistrationCode());
					return new UpdateCustomerResponse(customer);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateCustomerResponse(errors);
				});
	}

}