package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;
import lv.javaguru.java2.product.storage.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class GetAllProductsService {

    @DIDependency private Database database;

    public GetAllProductsResponse execute(GetAllProductsRequest request) {
        List<Product> products = database.getAllProducts();
        return new GetAllProductsResponse(products);
    }
}
