package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.GetClientRequest;
import lv.avangardteen.core.responce.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GetClientValidator {
    public List<CoreError> validate(GetClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(GetClientRequest request) {
        return (request.getId() == null)
                ? Optional.of(new CoreError("id", "Must not be empty!"))
                : Optional.empty();
    }
}
