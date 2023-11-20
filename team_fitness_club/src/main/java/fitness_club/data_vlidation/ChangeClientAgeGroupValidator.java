package fitness_club.data_vlidation;

import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class ChangeClientAgeGroupValidator {

    public List<CoreError> validate(ChangeClientAgeGroupRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        validateClientsAgeGroup(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(ChangeClientAgeGroupRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateClientsAgeGroup(ChangeClientAgeGroupRequest request) {
        return request.getClientAgeGroup() == null
                ? Optional.of(new CoreError("ageGroup", "Field must not be empty!"))
                : Optional.empty();
    }
}
