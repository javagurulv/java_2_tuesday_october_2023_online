package lv.javaguru.java2.product.storage.core.responses;

import java.util.List;

public class RemoveProductResponse extends CoreResponse {

    private boolean productRemoved;

    public RemoveProductResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveProductResponse(boolean productRemoved) {
        this.productRemoved = productRemoved;
    }

    public boolean isProductRemoved() {
        return productRemoved;
    }
}
