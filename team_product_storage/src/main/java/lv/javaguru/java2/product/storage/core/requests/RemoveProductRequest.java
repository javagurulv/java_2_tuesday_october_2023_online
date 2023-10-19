package lv.javaguru.java2.product.storage.core.requests;

public class RemoveProductRequest {

    private Long productIdToRemove;

    public RemoveProductRequest(Long productIdToRemove) {
        this.productIdToRemove = productIdToRemove;
    }

    public Long getProductIdToRemove() {
        return productIdToRemove;
    }
}
