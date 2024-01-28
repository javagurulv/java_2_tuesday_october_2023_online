package fitness_club.core.services.validators.client;

import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeleteClientByPersonalCodeRequestValidator {

    public List<CoreError> validate(DeleteClientByPersonalCodeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(DeleteClientByPersonalCodeRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Must not be empty!"))
                : Optional.empty();
    }
}
