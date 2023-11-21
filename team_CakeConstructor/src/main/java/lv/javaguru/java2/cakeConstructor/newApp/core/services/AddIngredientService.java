package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.AddIngredientRequestValidator;

import java.util.List;

public class AddIngredientService {

    private Database database;
    private AddIngredientRequestValidator validator;

    public AddIngredientService(Database database,
                                AddIngredientRequestValidator validator){
        this.database=database;
        this.validator=validator;
    }

    public AddIngredientResponse execute(AddIngredientRequest request){
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddIngredientResponse(errors);
        }

        Ingredient ingredient = new Ingredient(request.getType(), request.getTaste());
        database.save(ingredient);

        return new AddIngredientResponse(ingredient);
    }
}
