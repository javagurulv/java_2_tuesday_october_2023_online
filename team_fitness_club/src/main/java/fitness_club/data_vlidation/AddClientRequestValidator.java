package fitness_club.data_vlidation;

import fitness_club.requests.AddClientRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddClientRequestValidator {
    public List<CoreError> validate(AddClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateFirstName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validatePersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateFirstName(AddClientRequest request) {
        return request.getFirstName() == null || request.getFirstName().isEmpty()
                ? Optional.of(new CoreError("firstName", "Field first name must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validateLastName(AddClientRequest request) {
        return request.getLastName() == null || request.getLastName().isEmpty()
                ? Optional.of(new CoreError("lastName", "Field last name must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validatePersonalCode(AddClientRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }
}
