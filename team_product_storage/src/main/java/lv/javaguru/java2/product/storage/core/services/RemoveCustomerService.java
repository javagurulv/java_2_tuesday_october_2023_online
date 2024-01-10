package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.database.CustomerRepository;
import lv.javaguru.java2.product.storage.core.database.ProductRepository;
import lv.javaguru.java2.product.storage.core.requests.RemoveCustomerRequest;
import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.core.responses.RemoveCustomerResponse;
import lv.javaguru.java2.product.storage.core.responses.RemoveProductResponse;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveCustomerRequestValidator;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RemoveCustomerService {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private RemoveCustomerRequestValidator validator;


    public RemoveCustomerResponse execute(RemoveCustomerRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveCustomerResponse(errors);
        }
        boolean isCustomerRemoved = customerRepository.deleteById(request.getCustomerIdToRemove());
        return new RemoveCustomerResponse(isCustomerRemoved);
    }
}
