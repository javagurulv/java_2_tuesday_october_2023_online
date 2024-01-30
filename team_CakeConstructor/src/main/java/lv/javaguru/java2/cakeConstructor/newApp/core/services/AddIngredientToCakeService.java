package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientToCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientToCakeResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.AddIngredientToCakeRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddIngredientToCakeService {

    @Autowired private AddIngredientToCakeRequestValidator validator;
    @Autowired private JpaIngredientRepository ingredientRepository;
    @Autowired private JpaCakeRepository cakeRepository;
    @Autowired private JpaCakeIngredientRepository cakeIngredientRepository;


    public AddIngredientToCakeResponse execute(AddIngredientToCakeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddIngredientToCakeResponse(errors);
        }

        Cake cake = cakeRepository.getReferenceById(request.getCakeId());
        Ingredient ingredient = ingredientRepository.getReferenceById(request.getIngredientId());


        CakeIngredient cakeIngredient = new CakeIngredient();
        cakeIngredient.setCake(cake);
        cakeIngredient.setIngredient(ingredient);
        cakeIngredient.setQuantity(request.getQuantity());
        cakeIngredientRepository.save(cakeIngredient);

        return new AddIngredientToCakeResponse(null);
    }

}
