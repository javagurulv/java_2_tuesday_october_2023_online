package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class AddIngredientRequestValidator {

    public List<CoreError> validate(AddIngredientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateType(request).ifPresent(errors::add);
        validateTaste(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateType(AddIngredientRequest request) {
        return (request.getType() == null || request.getType().isEmpty())
                ? Optional.of(new CoreError("type", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateTaste(AddIngredientRequest request) {
        return (request.getTaste() == null || request.getTaste().isEmpty())
                ? Optional.of(new CoreError("taste", "Must not be empty!"))
                : Optional.empty();
    }

}
