package fitness_club.data_vlidation;

import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangeClientWorkoutsValidator {

    public List<CoreError> validate(ChangeClientWorkoutsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        validateWorkout(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(ChangeClientWorkoutsRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateWorkout(ChangeClientWorkoutsRequest request) {
        return request.getWorkout() == null
                ? Optional.of(new CoreError("workout", "Field must not be empty!"))
                : Optional.empty();
    }
}
