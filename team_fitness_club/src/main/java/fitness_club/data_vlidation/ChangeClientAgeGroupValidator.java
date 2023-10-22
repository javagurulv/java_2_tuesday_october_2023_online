package fitness_club.data_vlidation;

import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChangeClientAgeGroupValidator {

    public List<CoreError> validate(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(ChangeClientAgeGroupRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }
}
