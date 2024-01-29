package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetCakeResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.GetCakeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetCakeService {

	@Autowired private JpaCakeRepository cakeRepository;
	@Autowired private GetCakeValidator validator;

	public GetCakeResponse execute(GetCakeRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetCakeResponse(errors);
		}
		return cakeRepository.findById(request.getId())
				.map(GetCakeResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetCakeResponse(errors);
				});
	}

}