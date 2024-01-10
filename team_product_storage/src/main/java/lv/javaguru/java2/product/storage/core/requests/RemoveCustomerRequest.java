package lv.javaguru.java2.product.storage.core.requests;

public class RemoveCustomerRequest {

    private Long customerIdToRemove;

    public RemoveCustomerRequest(Long customerIdToRemove) {
        this.customerIdToRemove = customerIdToRemove;
    }

    public Long getCustomerIdToRemove() {
        return customerIdToRemove;
    }
}
