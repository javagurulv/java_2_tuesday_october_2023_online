package fitness_club.core.services.vlidators.workout;

import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class ChangeClientWorkoutsValidator {

    public List<CoreError> validate(ChangeClientWorkoutRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientId(request).ifPresent(errors::add);
        validateWorkoutId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientId(ChangeClientWorkoutRequest request) {
        return request.getClientId() == null
                ? Optional.of(new CoreError("clientId", "Field client id must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validateWorkoutId(ChangeClientWorkoutRequest request) {
        return request.getWorkoutId() == null
                ? Optional.of(new CoreError("workoutId", "Field workout id must not be empty!"))
                : Optional.empty();
    }
}
