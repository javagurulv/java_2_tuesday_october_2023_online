package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    void save(Customer customer);

    Customer findById(Long id);

    Optional<Customer> getById(Long id);

    boolean deleteById(Long id);

    List<Customer> getAllCustomers();

    List<Customer> findByCustomerName(String customerName);

    List<Customer> findByRegistrationCode(String registrationCode);

    List<Customer> findByCustomerNameAndRegistrationCode(String customerName, String registrationCode);


}
