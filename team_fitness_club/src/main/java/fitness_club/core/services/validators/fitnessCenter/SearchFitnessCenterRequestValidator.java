package fitness_club.core.services.validators.fitnessCenter;

import fitness_club.core.requests.SearchFitnessCenterRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchFitnessCenterRequestValidator {

    public List<CoreError> validate (SearchFitnessCenterRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getFitnessCenter())) {
            errors.add(new CoreError("fitnessCenter", "Must not be empty!"));

        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
