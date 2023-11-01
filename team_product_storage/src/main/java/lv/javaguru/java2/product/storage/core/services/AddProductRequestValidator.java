package lv.javaguru.java2.product.storage.core.services;

import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddProductRequestValidator {

    public List<CoreError> validate(AddProductRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateProductName(request).ifPresent(errors::add);
        validateProductBrand(request).ifPresent(errors::add);
        validateProductModel(request).ifPresent(errors::add);
        return errors;
    }


    private Optional<CoreError> validateProductName(AddProductRequest request) {
        return (request.getProductName() == null || request.getProductName().isEmpty())
                ? Optional.of(new CoreError("Product name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductBrand(AddProductRequest request) {
        return (request.getProductBrand() == null || request.getProductBrand().isEmpty())
                ? Optional.of(new CoreError("Product brand", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductModel(AddProductRequest request) {
        return (request.getProductModel() == null || request.getProductModel().isEmpty())
                ? Optional.of(new CoreError("Product model", "Must not be empty!"))
                : Optional.empty();
    }
}
