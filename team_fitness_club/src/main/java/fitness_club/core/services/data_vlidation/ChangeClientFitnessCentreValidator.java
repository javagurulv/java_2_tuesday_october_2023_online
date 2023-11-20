package fitness_club.core.services.data_vlidation;

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
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(ChangeClientFitnessCentreRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }
}
