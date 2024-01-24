package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.UpdateProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateProductRequestValidator {

	@Autowired
	private JpaProductRepository productRepository;

	public List<CoreError> validate(UpdateProductRequest request) {
		List<CoreError> errors = new ArrayList<>();
		validateProductIdEmpty(request).ifPresent(errors::add);
		validateProductIdExistInDb(request).ifPresent(errors::add);
		validateProductName(request).ifPresent(errors::add);
		validateProductBrand(request).ifPresent(errors::add);
		validateProductModel(request).ifPresent(errors::add);
		validateProductQuantity(request).ifPresent(errors::add);
		validatePrice(request).ifPresent(errors::add);
		return errors;
	}

	private Optional<CoreError> validateProductIdEmpty(UpdateProductRequest request) {
		return (request.getId() == null)
				? Optional.of(new CoreError("productId", "Must not be empty!"))
				: Optional.empty();
	}


	private Optional<CoreError> validateProductIdExistInDb(UpdateProductRequest request) {
		if (request.getId() != null) {
			Optional<Product> productOpt = productRepository.findById(request.getId());
			return (productOpt.isEmpty())
					? Optional.of(new CoreError("productId", "Not exist!"))
					: Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	private Optional<CoreError> validateProductName(UpdateProductRequest request) {
		return (request.getNewProductName() == null || request.getNewProductName().isEmpty())
			? Optional.of(new CoreError("newProductName", "Must not be empty!"))
			: Optional.empty();
	}

	private Optional<CoreError> validateProductBrand(UpdateProductRequest request) {
		return (request.getNewProductBrand() == null || request.getNewProductBrand().isEmpty())
				? Optional.of(new CoreError("newProductBrand", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateProductModel(UpdateProductRequest request) {
		return (request.getNewProductModel() == null || request.getNewProductModel().isEmpty())
				? Optional.of(new CoreError("newProductModel", "Must not be empty!"))
				: Optional.empty();
	}

	private Optional<CoreError> validateProductQuantity(UpdateProductRequest request) {
		return (request.getNewProductQuantity() == null )
				? Optional.of(new CoreError("newProductQuantity", "Must be greater than 0!"))
				: Optional.empty();
	}

	private Optional<CoreError> validatePrice(UpdateProductRequest request) {
		BigDecimal minPrice = new BigDecimal("0.01");
		return (request.getNewPrice() == null)
				? Optional.of(new CoreError("newPrice", "Must be greater than 0.00!"))
				: Optional.empty();
	}

}
