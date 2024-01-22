package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.requests.GetProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.GetProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.GetProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetProductService {

	@Autowired private JpaProductRepository productRepository;
	@Autowired private GetProductValidator validator;

	public GetProductResponse execute(GetProductRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new GetProductResponse(errors);
		}
		return productRepository.findById(request.getId())
				.map(GetProductResponse::new)
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new GetProductResponse(errors);
				});
	}

}