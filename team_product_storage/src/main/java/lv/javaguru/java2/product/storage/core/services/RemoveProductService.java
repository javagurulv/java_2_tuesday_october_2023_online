package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;
import lv.javaguru.java2.product.storage.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class RemoveProductService {

    @DIDependency private Database database;
    @DIDependency private RemoveProductRequestValidator validator;


    public RemoveProductResponse execute(RemoveProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveProductResponse(errors);
        }
        boolean isProductRemoved = database.deleteById(request.getProductIdToRemove());
        return new RemoveProductResponse(isProductRemoved);
    }
}
