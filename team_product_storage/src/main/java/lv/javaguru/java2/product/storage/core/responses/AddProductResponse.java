package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public class AddProductResponse extends CoreResponse {

    private Product newProduct;

    public AddProductResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddProductResponse(Product newProduct) {
        this.newProduct = newProduct;
    }

    public Product getNewProduct() {
        return newProduct;
    }
}
