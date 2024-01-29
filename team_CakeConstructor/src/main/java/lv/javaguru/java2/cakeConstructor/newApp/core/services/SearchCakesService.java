package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchCakesResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.SearchCakesRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class SearchCakesService {

	@Autowired private JpaCakeRepository cakeRepository;
	@Autowired private SearchCakesRequestValidator validator;

	public SearchCakesResponse execute(SearchCakesRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new SearchCakesResponse(null, errors);
		}

		List<Cake> cakes = search(request);

		return new SearchCakesResponse(cakes, null);
	}

	private List<Cake> search(SearchCakesRequest request) {
		List<Cake> cakes = new ArrayList<>();
		if (request.isCakeNameProvided() && !request.isWeightProvided()) {
			cakes  = cakeRepository.findByCakeNameLike(request.getCakeName());
		}
		if (!request.isCakeNameProvided() && request.isWeightProvided()) {
			cakes = cakeRepository.findByWeightLike(request.getWeight());
		}
		if (request.isCakeNameProvided() && request.isWeightProvided()) {
			cakes = cakeRepository.findByCakeNameAndWeightLike(request.getCakeName(), request.getWeight());
		}
		return cakes;
	}

}
