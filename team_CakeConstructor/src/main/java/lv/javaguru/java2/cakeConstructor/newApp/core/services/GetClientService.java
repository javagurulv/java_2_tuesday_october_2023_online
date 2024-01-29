package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.GetClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetClientService {

	@Autowired private JpaClientRepository clientRepository;
	@Autowired private GetClientValidator validator;

	public GetClientResponse execute(GetClientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetClientResponse(errors);
		}
		return clientRepository.findById(request.getId())
				.map(GetClientResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetClientResponse(errors);
				});
	}

}