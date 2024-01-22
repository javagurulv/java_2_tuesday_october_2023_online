package fitness_club.core.services.validators.client;

import fitness_club.core.requests.SearchClientsRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchClientsRequestFieldValidator {

    public List<CoreError> validate (SearchClientsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getFirstName()) && isEmpty(request.getLastName()) && isEmpty(request.getPersonalCode())) {
            errors.add(new CoreError("firstName", "Must not be empty!"));
            errors.add(new CoreError("lastName", "Must not be empty!"));
            errors.add(new CoreError("personalCode", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
