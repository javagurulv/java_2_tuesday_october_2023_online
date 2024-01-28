package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.requests.GetCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.GetCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.validators.GetCustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetCustomerService {

	@Autowired private JpaCustomerRepository customerRepository;
	@Autowired private GetCustomerValidator validator;

	public GetCustomerResponse execute(GetCustomerRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetCustomerResponse(errors);
		}
		return customerRepository.findById(request.getId())
				.map(GetCustomerResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetCustomerResponse(errors);
				});
	}

}