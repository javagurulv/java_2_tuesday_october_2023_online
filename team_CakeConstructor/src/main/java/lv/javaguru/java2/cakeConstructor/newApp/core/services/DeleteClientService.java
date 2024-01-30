package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.DeleteClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.DeleteClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.DeleteClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteClientService {

	@Autowired private JpaClientRepository clientRepository;
	@Autowired private DeleteClientValidator validator;

	public DeleteClientResponse execute(DeleteClientRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new DeleteClientResponse(errors);
		}
		return clientRepository.findById(request.getId())
				.map(client -> {
					clientRepository.deleteById(request.getId());
					return new DeleteClientResponse(client);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new DeleteClientResponse(errors);
				});
	}

}