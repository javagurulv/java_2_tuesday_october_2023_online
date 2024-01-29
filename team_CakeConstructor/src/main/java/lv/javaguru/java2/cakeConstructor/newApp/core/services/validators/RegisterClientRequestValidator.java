package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RegisterClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class RegisterClientRequestValidator {

	@Autowired private JpaClientRepository clientRepository;

	public List<CoreError> validate(RegisterClientRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateFirstName(request).ifPresent(errors::add);
		validateLastName(request).ifPresent(errors::add);
		validatePersonalCode(request).ifPresent(errors::add);
		validateDuplicate(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateFirstName(RegisterClientRequest request) {
		return (request.getFirstName() == null || request.getFirstName().isEmpty())
				? Optional.of(new CoreError("firstName", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateLastName(RegisterClientRequest request) {
		return (request.getLastName() == null || request.getLastName().isEmpty())
				? Optional.of(new CoreError("lastName", "Must not be empty!"))
				: Optional.empty();
	}


	private Optional<CoreError> validatePersonalCode(RegisterClientRequest request) {
		return (request.getPersonalCode() == null || request.getPersonalCode().isEmpty())
				? Optional.of(new CoreError("personalCode", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateDuplicate(RegisterClientRequest request) {
		List<Client> clients = clientRepository.findByFirstNameAndLastNameAndPersonalCode(request.getFirstName(), request.getLastName(), request.getPersonalCode());
		return (!clients.isEmpty())
				? Optional.of(new CoreError("duplicate", "Duplicate client not accepted!"))
				: Optional.empty();
	}

}