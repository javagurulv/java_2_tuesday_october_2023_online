package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RegisterClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RegisterClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RegisterClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RegisterClientService {

	@Autowired private JpaClientRepository clientRepository;
	@Autowired private RegisterClientRequestValidator validator;

	public RegisterClientResponse execute(RegisterClientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new RegisterClientResponse(errors);
		}

		Client client = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode());
		clientRepository.save(client);

		return new RegisterClientResponse(client);
	}

}