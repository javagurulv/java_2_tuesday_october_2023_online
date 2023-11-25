package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RemoveIngredientRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIComponent;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class RemoveIngredientService {

    @DIDependency private Database database;
    @DIDependency private RemoveIngredientRequestValidator validator;


    public RemoveIngredientResponse execute(RemoveIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveIngredientResponse(errors);
        }
        boolean isBookRemoved = database.deleteById(request.getIngredientId());
        return new RemoveIngredientResponse(isBookRemoved);
    }

}