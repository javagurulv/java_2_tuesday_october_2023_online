package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.services.validators.AddProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddProductService {

    @Autowired private JpaProductRepository productRepository;
    @Autowired private AddProductRequestValidator validator;

    public AddProductResponse execute(AddProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddProductResponse(errors);
        }

        Product product = new Product(
                request.getProductName(),
                request.getProductBrand(),
                request.getProductModel(),
                request.getProductQuantity(),
                request.getPrice());
        productRepository.save(product);
        return new AddProductResponse(product);
    }

}
