package fitness_club.core.services.validators.client;

import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoveClientByIdRequestValidator {

    public List<CoreError> validate(RemoveClientByPersonalCodeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientPersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientPersonalCode(RemoveClientByPersonalCodeRequest request) {
        return request.getPersonalCode() == null
                ? Optional.of(new CoreError("PersonalCode", "Must not be empty!"))
                : Optional.empty();
    }
}
