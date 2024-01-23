package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.RemoveProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RemoveProductRequestValidator {

    public List<CoreError> validate(RemoveProductRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateProductId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateProductId(RemoveProductRequest request) {
        return (request.getProductId() == null)
                ? Optional.of(new CoreError("productId", "Must not be empty!"))
                : Optional.empty();
    }

}
