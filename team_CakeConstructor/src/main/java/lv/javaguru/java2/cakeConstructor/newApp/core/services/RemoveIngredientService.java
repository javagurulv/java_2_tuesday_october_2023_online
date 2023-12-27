package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.IngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RemoveIngredientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemoveIngredientService {

    @Autowired private IngredientRepository ingredientRepository;
    @Autowired private RemoveIngredientRequestValidator validator;


    public RemoveIngredientResponse execute(RemoveIngredientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveIngredientResponse(errors);
        }
        boolean isBookRemoved = ingredientRepository.deleteById(request.getIngredientId());
        return new RemoveIngredientResponse(isBookRemoved);
    }

}