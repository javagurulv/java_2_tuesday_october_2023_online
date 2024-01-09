package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchCustomersRequestFieldValidator {

    public List<CoreError> validate(SearchCustomersRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getCustomerName()) && isEmpty(request.getRegistrationCode())) {
            errors.add(new CoreError("customerName", "Must not be empty!"));
            errors.add(new CoreError("registrationCode", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
