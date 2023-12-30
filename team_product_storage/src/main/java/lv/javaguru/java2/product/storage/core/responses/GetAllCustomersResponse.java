package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Customer;

import java.util.List;

public class GetAllCustomersResponse extends CoreResponse {

    private List<Customer> customers;

    public GetAllCustomersResponse(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
