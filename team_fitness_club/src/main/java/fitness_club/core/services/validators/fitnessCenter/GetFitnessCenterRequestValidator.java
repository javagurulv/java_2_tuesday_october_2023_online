package fitness_club.core.services.validators.fitnessCenter;

import fitness_club.core.requests.GetFitnessCenterRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetFitnessCenterRequestValidator {
    public List<CoreError> validate(GetFitnessCenterRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateFitnessCenterId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateFitnessCenterId(GetFitnessCenterRequest request) {
        return request.getId() == null
                ? Optional.of(new CoreError("Id", "Must not be empty!"))
                : Optional.empty();
    }
}
