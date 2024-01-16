package fitness_club.core.services.vlidators.fitnessCenter;

import fitness_club.core.requests.ChangeClientFitnessCenterRequest;
import fitness_club.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class ChangeClientFitnessCenterValidator {

    public List<CoreError> validate(ChangeClientFitnessCenterRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientId(request).ifPresent(errors::add);
        validateFitnessCenterId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientId(ChangeClientFitnessCenterRequest request) {
        return request.getClientId() == null
                ? Optional.of(new CoreError("clientId", "Field client id must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validateFitnessCenterId(ChangeClientFitnessCenterRequest request) {
        return request.getFitnessCenterId() == null
                ? Optional.of(new CoreError("fitnessCenterId", "Field fitness center id must not be empty!"))
                : Optional.empty();
    }
}
