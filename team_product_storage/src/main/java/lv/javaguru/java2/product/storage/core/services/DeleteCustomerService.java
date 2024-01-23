package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.services.validators.DeleteCustomerValidator;
import lv.javaguru.java2.product.storage.core.requests.DeleteCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.DeleteCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteCustomerService {

	@Autowired private JpaCustomerRepository customerRepository;
	@Autowired private DeleteCustomerValidator validator;

	public DeleteCustomerResponse execute(DeleteCustomerRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new DeleteCustomerResponse(errors);
		}
		return customerRepository.findById(request.getId())
				.map(customer -> {
					customerRepository.deleteById(request.getId());
					return new DeleteCustomerResponse(customer);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new DeleteCustomerResponse(errors);
				});
	}

}