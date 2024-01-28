package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaProductRepository;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RemoveProductService {

    @Autowired private JpaProductRepository productRepository;
    @Autowired private RemoveProductRequestValidator validator;


    public RemoveProductResponse execute(RemoveProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveProductResponse(errors);
        }
        productRepository.deleteById(request.getProductId());
        return new RemoveProductResponse(true);
    }
}
