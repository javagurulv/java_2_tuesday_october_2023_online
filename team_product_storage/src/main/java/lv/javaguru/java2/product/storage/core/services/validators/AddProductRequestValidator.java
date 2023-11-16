package lv.javaguru.java2.product.storage.core.services.validators;

import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.CoreError;
import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
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
                ? Optional.of(new CoreError("productName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductBrand(AddProductRequest request) {
        return (request.getProductBrand() == null || request.getProductBrand().isEmpty())
                ? Optional.of(new CoreError("productBrand", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateProductModel(AddProductRequest request) {
        return (request.getProductModel() == null || request.getProductModel().isEmpty())
                ? Optional.of(new CoreError("productModel", "Must not be empty!"))
                : Optional.empty();
    }
}
