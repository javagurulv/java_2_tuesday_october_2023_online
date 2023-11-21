package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.AddIngredientRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIComponent;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class AddIngredientService {

    @DIDependency private Database database;
    @DIDependency private AddIngredientRequestValidator validator;


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
