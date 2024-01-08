package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.ProductRepository;
import lv.javaguru.java2.product.storage.core.requests.UpdateProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.UpdateProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.UpdateProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateProductService {

	@Autowired private ProductRepository productRepository;
	@Autowired private UpdateProductRequestValidator validator;

	public UpdateProductResponse execute(UpdateProductRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new UpdateProductResponse(errors);
		}

		return productRepository.getById(request.getId())
				.map(product -> {
					product.setProductName(request.getNewProductName());
					product.setProductBrand(request.getNewProductBrand());
					product.setProductModel(request.getNewProductModel());
					product.setProductQuantity(request.getNewProductQuantity());
					product.setPrice(request.getNewPrice());
					return new UpdateProductResponse(product);
				})
				.orElseGet(() -> {
					errors.add(new CoreError("id", "Not found!"));
					return new UpdateProductResponse(errors);
				});
	}

}