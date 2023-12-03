package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchIngredientsRequestFieldValidator {

    public List<CoreError> validate(SearchIngredientsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getType()) && isEmpty(request.getTaste())) {
            errors.add(new CoreError("type", "Must not be empty!"));
            errors.add(new CoreError("taste", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}

