package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RemoveIngredientRequestValidator;

import java.util.List;

public class RemoveIngredientService {

    private Database database;
    private RemoveIngredientRequestValidator validator;

    public RemoveIngredientService(Database database,
                             RemoveIngredientRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public RemoveIngredientResponse execute(RemoveIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveIngredientResponse(errors);
        }
        boolean isBookRemoved = database.deleteById(request.getIngredientId());
        return new RemoveIngredientResponse(isBookRemoved);
    }

}