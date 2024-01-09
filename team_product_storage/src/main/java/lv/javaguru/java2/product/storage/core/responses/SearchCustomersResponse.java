package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Customer;

import java.util.List;

public class SearchCustomersResponse extends CoreResponse {

    private List<Customer> customers;

    public SearchCustomersResponse(List<Customer> customers, List<CoreError> errors) {
        super(errors);
        this.customers = customers;

    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

