package lv.javaguru.java2.product.storage.core.responses;

import java.util.List;

public class RemoveCustomerResponse extends CoreResponse {

    private boolean customerRemoved;

    public RemoveCustomerResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveCustomerResponse(boolean customerRemoved) {
        this.customerRemoved = customerRemoved;
    }

    public boolean isCustomerRemoved() {
        return customerRemoved;
    }
}
