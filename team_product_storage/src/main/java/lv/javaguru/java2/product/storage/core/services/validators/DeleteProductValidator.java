package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.DeleteProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeleteProductValidator {

	@Autowired private JpaProductRepository productRepository;

	public List<CoreError> validate(DeleteProductRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateId(request).ifPresent(errors::add);
		validateIdExistInDb(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateId(DeleteProductRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("productId", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateIdExistInDb(DeleteProductRequest request) {
		if (request.getId() != null) {
			Optional<Product> productOpt = productRepository.findById(request.getId());
			return (productOpt.isEmpty())
					? Optional.of(new CoreError("productId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

}