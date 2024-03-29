package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.requests.GetAllCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllCustomersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllCustomersService {
    @Autowired private JpaCustomerRepository readerRepository;

    public GetAllCustomersResponse execute(GetAllCustomersRequest request) {
        List<Customer> customers = readerRepository.findAll();
        return new GetAllCustomersResponse(customers);
    }
}