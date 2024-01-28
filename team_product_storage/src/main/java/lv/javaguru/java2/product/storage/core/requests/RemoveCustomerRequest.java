package lv.javaguru.java2.product.storage.core.requests;

public class RemoveCustomerRequest {

    private Long customerId;

    public RemoveCustomerRequest(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
