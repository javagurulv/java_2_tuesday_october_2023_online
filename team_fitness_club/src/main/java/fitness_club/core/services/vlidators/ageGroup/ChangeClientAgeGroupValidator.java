package fitness_club.core.services.vlidators.ageGroup;

import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class ChangeClientAgeGroupValidator {

    public List<CoreError> validate(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientId(request).ifPresent(errors::add);
        validateAgeGroupId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientId(ChangeClientAgeGroupRequest request) {
        return request.getClientId() == null 
                ? Optional.of(new CoreError("clientId", "Field client Id must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAgeGroupId(ChangeClientAgeGroupRequest request) {
        return request.getClientAgeGroupId() == null
                ? Optional.of(new CoreError("ageGroupId", "Field age group Id must not be empty!"))
                : Optional.empty();
    }
}
