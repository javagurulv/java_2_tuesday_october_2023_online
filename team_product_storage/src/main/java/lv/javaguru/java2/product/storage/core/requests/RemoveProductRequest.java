package lv.javaguru.java2.product.storage.core.requests;

public class RemoveProductRequest {

    private Long productId;

    public RemoveProductRequest(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
