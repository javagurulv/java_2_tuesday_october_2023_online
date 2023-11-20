package fitness_club.data_vlidation;

import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class ChangeClientFitnessCentreValidator {

    public List<CoreError> validate(ChangeClientFitnessCentreRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        validateFitnessCentre(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(ChangeClientFitnessCentreRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateFitnessCentre(ChangeClientFitnessCentreRequest request) {
        return request.getFitnessCentre() == null
                ? Optional.of(new CoreError("fitnessCentre", "Field must not be empty!"))
                : Optional.empty();
    }
}
