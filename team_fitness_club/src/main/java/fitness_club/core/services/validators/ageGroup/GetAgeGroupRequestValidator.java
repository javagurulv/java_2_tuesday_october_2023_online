package fitness_club.core.services.validators.ageGroup;


import fitness_club.core.requests.GetAgeGroupRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetAgeGroupRequestValidator {
    public List<CoreError> validate(GetAgeGroupRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateAgeGroupId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateAgeGroupId(GetAgeGroupRequest request) {
        return request.getId() == null
                ? Optional.of(new CoreError("Id", "Must not be empty!"))
                : Optional.empty();
    }
}
