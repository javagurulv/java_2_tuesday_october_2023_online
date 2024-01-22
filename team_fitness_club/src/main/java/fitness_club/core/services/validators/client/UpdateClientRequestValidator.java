package fitness_club.core.services.validators.client;


import fitness_club.core.requests.UpdateClientRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UpdateClientRequestValidator {
    public List<CoreError> validate(UpdateClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateFirstName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validatePersonalCode(request).ifPresent(errors::add);
        validateFirstNameNoSymbols(request).ifPresent(errors::add);
        validateLastNameNoSymbols(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateFirstName(UpdateClientRequest request) {
        return request.getNewName() == null || request.getNewName().isEmpty()
                ? Optional.of(new CoreError("newFirstName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateLastName(UpdateClientRequest request) {
        return request.getNewLastName() == null || request.getNewLastName().isEmpty() || !request.getNewLastName().matches("[a-zA-Z]+")
                ? Optional.of(new CoreError("newLastName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePersonalCode(UpdateClientRequest request) {
        return request.getNewPersonalCode() == null || request.getNewPersonalCode().isEmpty()
                ? Optional.of(new CoreError("newPersonalCode", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateFirstNameNoSymbols(UpdateClientRequest request) {
        return request.getNewName().matches("[a-zA-Z]+")
                ? Optional.of(new CoreError("newFirstName", "Must not contain symbols!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateLastNameNoSymbols(UpdateClientRequest request) {
        return !request.getNewLastName().matches("[a-zA-Z]+")
                ? Optional.of(new CoreError("newLastName", "Must not contain symbols!"))
                : Optional.empty();
    }

}
