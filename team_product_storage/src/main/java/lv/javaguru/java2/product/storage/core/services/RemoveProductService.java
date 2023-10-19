package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;

public class RemoveProductService {

    private Database database;

    public RemoveProductService(Database database) {
        this.database = database;
    }

    public RemoveProductResponse execute(RemoveProductRequest request) {
        boolean isProductRemoved = database.deleteById(request.getProductIdToRemove());
        return new RemoveProductResponse(isProductRemoved);
    }


}
