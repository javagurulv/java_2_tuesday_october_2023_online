package fitness_club.core.services.vlidators;

import fitness_club.core.requests.RegisterClientRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegisterClientRequestValidator {
    public List<CoreError> validate(RegisterClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateFirstName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validatePersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateFirstName(RegisterClientRequest request) {
        return (request.getFirstName() == null || request.getFirstName().isEmpty())
                ? Optional.of(new CoreError("firstName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateLastName(RegisterClientRequest request) {
        return (request.getLastName() == null || request.getLastName().isEmpty())
                ? Optional.of(new CoreError("lastName", "Must not be empty!"))
                : Optional.empty();
    }
    private Optional<CoreError> validatePersonalCode(RegisterClientRequest request) {
        return (request.getPersonalCode() == null || request.getPersonalCode().isEmpty())
                ? Optional.of(new CoreError("personalCode", "Must not be empty!"))
                : Optional.empty();
    }
}
