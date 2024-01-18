package fitness_club.core.services.validators.workout;

import fitness_club.core.requests.SearchAgeGroupRequest;
import fitness_club.core.requests.SearchWorkoutRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchWorkoutRequestValidator {

    public List<CoreError> validate (SearchWorkoutRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getWorkout())) {
            errors.add(new CoreError("workout", "Must not be empty!"));

        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
