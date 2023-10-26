package fitness_club.data_vlidation;

import fitness_club.core.requests.SearchClientRequest;

import java.util.ArrayList;
import java.util.List;

public class SearchClientRequestValidator {

    public List<CoreError> validate(SearchClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchClientRequest request) {
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
