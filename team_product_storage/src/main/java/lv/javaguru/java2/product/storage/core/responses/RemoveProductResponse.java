package lv.javaguru.java2.product.storage.core.responses;

public class RemoveProductResponse {

    private boolean productRemoved;

    public RemoveProductResponse(boolean productRemoved) {
        this.productRemoved = productRemoved;
    }

    public boolean isProductRemoved() {
        return productRemoved;
    }
}
