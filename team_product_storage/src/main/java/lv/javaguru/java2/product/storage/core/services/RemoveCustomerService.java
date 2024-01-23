package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.jpa.JpaCustomerRepository;
import lv.javaguru.java2.product.storage.core.requests.RemoveCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveCustomerRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RemoveCustomerService {

    @Autowired private JpaCustomerRepository customerRepository;
    @Autowired private RemoveCustomerRequestValidator validator;


    public RemoveCustomerResponse execute(RemoveCustomerRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveCustomerResponse(errors);
        }
        customerRepository.deleteById(request.getCustomerId());
        return new RemoveCustomerResponse(true);
    }
}
