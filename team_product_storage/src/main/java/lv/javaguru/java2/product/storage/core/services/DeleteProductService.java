package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.ProductRepository;
import lv.javaguru.java2.product.storage.core.requests.DeleteProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.DeleteProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.DeleteProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteProductService {

	@Autowired private ProductRepository productRepository;
	@Autowired private DeleteProductValidator validator;

	public DeleteProductResponse execute(DeleteProductRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new DeleteProductResponse(errors);
		}
		return productRepository.getById(request.getId())
				.map(product -> {
					productRepository.deleteById(request.getId());
					return new DeleteProductResponse(product);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new DeleteProductResponse(errors);
				});
	}

}