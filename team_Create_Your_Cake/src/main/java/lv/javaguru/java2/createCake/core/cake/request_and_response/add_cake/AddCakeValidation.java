package lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake;

import lv.javaguru.java2.createCake.core.cake.request_and_response.CoreError;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class AddCakeValidation {
    public List<CoreError> validate(AddCakeRequestForUnregistUser request){
        List<CoreError> errors = new ArrayList<>();
        validateClientId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientId (AddCakeRequestForUnregistUser request){
        return  ( request.getClientLogin() == null || request.getClientLogin().isEmpty())
                ? Optional.of(new CoreError("Client id", "Must not be empty!"))
                : Optional.empty();

    }
}
