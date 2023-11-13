package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.request.AddIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddIngridientValidation {

    public List<CoreError> validate(AddIngridientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateTitle(request).ifPresent(errors::add);
        validateAuthor(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateTitle(AddIngridientRequest request) {
        return (request.getTypeOfIngridient() == null || request.getTypeOfIngridient().isEmpty())
                ? Optional.of(new CoreError("type", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAuthor(AddIngridientRequest request) {
        return (request.getTasteOfIngridient() == null || request.getTasteOfIngridient().isEmpty())
                ? Optional.of(new CoreError("author", "Must not be empty!"))
                : Optional.empty();
    }

}
