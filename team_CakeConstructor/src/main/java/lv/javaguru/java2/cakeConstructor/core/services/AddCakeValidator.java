package lv.javaguru.java2.cakeConstructor.core.services;

import lv.javaguru.java2.cakeConstructor.core.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddCakeValidator {

    public List<CoreError> validate(AddCakeRequest request){
        List<CoreError> errors = new ArrayList<>();
        validateClientId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientId (AddCakeRequest request){
       return  ( request.getClientLogin() == null || request.getClientLogin().isEmpty())
                ? Optional.of(new CoreError("Client id", "Must not be empty!"))
                : Optional.empty();

    }
}
