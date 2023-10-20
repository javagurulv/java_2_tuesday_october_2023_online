package fitness_club.data_vlidation;

import fitness_club.requests.AddClientRequest;
import fitness_club.requests.DeleteClientRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeleteClientRequestValidator {

    public List<CoreError> validate(DeleteClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCode(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCode(DeleteClientRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }
}
