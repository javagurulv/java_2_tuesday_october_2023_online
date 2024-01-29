package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.CreateCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class CreateCakeRequestValidator {

    @Autowired private JpaCakeRepository cakeRepository;

    public List<CoreError> validate(CreateCakeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateCakeName(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateCakeName(CreateCakeRequest request) {
        return (request.getCakeName() == null || request.getCakeName().isEmpty())
                ? Optional.of(new CoreError("cakeName", "Must not be empty!"))
                : Optional.empty();
    }



}
