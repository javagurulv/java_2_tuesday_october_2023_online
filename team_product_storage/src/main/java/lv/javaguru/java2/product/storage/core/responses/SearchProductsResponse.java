package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public class SearchProductsResponse extends CoreResponse {

    private List<Product> products;

    public SearchProductsResponse(List<Product> products, List<CoreError> errors) {
        super(errors);
        this.products = products;

    }

    public List<Product> getProducts() {
        return products;
    }
}

