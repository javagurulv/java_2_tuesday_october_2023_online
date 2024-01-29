package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddIngredientRequestValidator {

    @Autowired private JpaIngredientRepository ingredientRepository;

    public List<CoreError> validate(AddIngredientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateType(request).ifPresent(errors::add);
        validateTaste(request).ifPresent(errors::add);
        validateDuplicate(request).ifPresent(errors::add);
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

    private Optional<CoreError> validateDuplicate(AddIngredientRequest request) {
        List<Ingredient> ingredients = ingredientRepository.findByTypeAndTaste(request.getType(), request.getTaste());
        return (!ingredients.isEmpty())
                ? Optional.of(new CoreError("duplicate", "Duplicate ingredient not accepted!"))
                : Optional.empty();
    }

}
