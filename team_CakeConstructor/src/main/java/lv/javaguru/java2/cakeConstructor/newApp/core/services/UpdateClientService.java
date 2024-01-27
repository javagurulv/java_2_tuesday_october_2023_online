package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.UpdateClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.UpdateClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateClientService {

	@Autowired private JpaClientRepository clientRepository;
	@Autowired private UpdateClientRequestValidator validator;

	public UpdateClientResponse execute(UpdateClientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateClientResponse(errors);
		}

		return clientRepository.findById(request.getId())
				.map(client -> {
					client.setFirstName(request.getNewFirstName());
					client.setLastName(request.getNewLastName());
					client.setPersonalCode(request.getNewPersonalCode());
					return new UpdateClientResponse(client);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateClientResponse(errors);
				});
	}

}