package fitness_club.core.services.validators.workout;


import fitness_club.core.requests.GetWorkoutRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetWorkoutRequestValidator {
    public List<CoreError> validate(GetWorkoutRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateWorkoutId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateWorkoutId(GetWorkoutRequest request) {
        return request.getId() == null
                ? Optional.of(new CoreError("Id", "Must not be empty!"))
                : Optional.empty();
    }
}
