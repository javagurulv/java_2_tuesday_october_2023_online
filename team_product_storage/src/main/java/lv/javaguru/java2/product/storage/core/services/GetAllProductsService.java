package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsService {

    @Autowired
    private Database database;

    public GetAllProductsResponse execute(GetAllProductsRequest request) {
        List<Product> products = database.getAllProducts();
        return new GetAllProductsResponse(products);
    }
}
