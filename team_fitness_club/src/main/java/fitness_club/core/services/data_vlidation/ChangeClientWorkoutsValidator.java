package fitness_club.core.services.data_vlidation;

import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class ChangeClientWorkoutsValidator {

    public List<CoreError> validate(ChangeClientWorkoutsRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(ChangeClientWorkoutsRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }
}
