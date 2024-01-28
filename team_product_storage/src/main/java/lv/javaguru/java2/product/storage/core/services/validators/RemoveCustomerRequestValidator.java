package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.RemoveCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoveCustomerRequestValidator {

    public List<CoreError> validate(RemoveCustomerRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateCustomerId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateCustomerId(RemoveCustomerRequest request) {
        return (request.getCustomerId() == null)
                ? Optional.of(new CoreError("customerId", "Must not be empty!"))
                : Optional.empty();
    }

}
