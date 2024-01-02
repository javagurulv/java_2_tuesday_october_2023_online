package lv.javaguru.java2.product.storage.matchers;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.domain.Product;
import org.mockito.ArgumentMatcher;

import java.math.BigDecimal;
import java.util.Objects;

public class CustomerMatcher implements ArgumentMatcher<Customer> {

    private String customerName;
    private String registrationCode;


    public CustomerMatcher(String customerName, String registrationCode) {
        this.customerName = customerName;
        this.registrationCode = registrationCode;
    }

    @Override
    public boolean matches(Customer customer) {
        return customer.getCustomerName().equals(customerName)
                && customer.getRegistrationCode().equals(registrationCode);

    }
}
