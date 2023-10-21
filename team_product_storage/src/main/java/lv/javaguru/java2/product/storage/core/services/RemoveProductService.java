package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoveProductService {

    private Database database;

    public RemoveProductService(Database database) {
        this.database = database;
    }

    public RemoveProductResponse execute(RemoveProductRequest request) {
        if (request.getProductIdToRemove() == null) {
            CoreError error = new CoreError("id", "Must not be empty!");
            List<CoreError> errors = new ArrayList<>();
            errors.add(error);
            return new RemoveProductResponse(errors);
        }
        boolean isProductRemoved = database.deleteById(request.getProductIdToRemove());
        return new RemoveProductResponse(isProductRemoved);
    }
}
