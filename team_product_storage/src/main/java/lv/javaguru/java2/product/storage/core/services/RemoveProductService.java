package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class RemoveProductService {

    private Database database;

    private RemoveProductRequestValidator validator;

    public RemoveProductService(Database database, RemoveProductRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public RemoveProductResponse execute(RemoveProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveProductResponse(errors);
        }
        boolean isProductRemoved = database.deleteById(request.getProductIdToRemove());
        return new RemoveProductResponse(isProductRemoved);
    }
}
