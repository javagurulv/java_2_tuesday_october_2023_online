package fitness_club.core.services.validators.memberCard;

import fitness_club.core.requests.GetMemberCardRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetMemberCardRequestValidator {
    public List<CoreError> validate(GetMemberCardRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateMemberCardId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateMemberCardId(GetMemberCardRequest request) {
        return request.getId() == null
                ? Optional.of(new CoreError("Id", "Must not be empty!"))
                : Optional.empty();
    }
}
