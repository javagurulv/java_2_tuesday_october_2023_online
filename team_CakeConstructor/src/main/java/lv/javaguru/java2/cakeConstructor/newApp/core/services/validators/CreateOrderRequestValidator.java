package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaOrderRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.CreateOrderRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CreateOrderRequestValidator {

	@Autowired private JpaClientRepository clientRepository;
	@Autowired private JpaCakeRepository cakeRepository;
	@Autowired private JpaOrderRepository orderRepository;

	public List<CoreError> validate(CreateOrderRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateClientIdEmpty(request).ifPresent(errors::add);
		validateCakeIdEmpty(request).ifPresent(errors::add);
		validateClientIdExistInDb(request).ifPresent(errors::add);
		validateCakeIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateClientIdEmpty(CreateOrderRequest request) {
		return (request.getClientId() == null)
				? Optional.of(new CoreError("clientId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateCakeIdEmpty(CreateOrderRequest request) {
		return (request.getCakeId() == null)
				? Optional.of(new CoreError("cakeId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateClientIdExistInDb(CreateOrderRequest request) {
		if (request.getClientId() != null) {
			Optional<Client> clientOpt = clientRepository.findById(request.getClientId());
			return (clientOpt.isEmpty())
					? Optional.of(new CoreError("clientId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateCakeIdExistInDb(CreateOrderRequest request) {
		if (request.getCakeId() != null) {
			Optional<Cake> cakeOpt = cakeRepository.findById(request.getCakeId());
			return (cakeOpt.isEmpty())
					? Optional.of(new CoreError("cakeId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

}







