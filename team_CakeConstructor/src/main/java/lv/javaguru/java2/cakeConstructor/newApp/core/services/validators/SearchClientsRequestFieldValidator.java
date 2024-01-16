package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchClientsRequestFieldValidator {

    public List<CoreError> validate(SearchClientsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getFirstName()) && isEmpty(request.getLastName())) {
            errors.add(new CoreError("firstName", "Must not be empty!"));
            errors.add(new CoreError("lastName", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

