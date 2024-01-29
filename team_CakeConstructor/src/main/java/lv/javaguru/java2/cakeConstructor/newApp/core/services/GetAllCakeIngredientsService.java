package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllCakeIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllCakeIngredientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllCakeIngredientsService {
    @Autowired private JpaCakeIngredientRepository cakeIngredientRepository;

    public GetAllCakeIngredientsResponse execute(GetAllCakeIngredientsRequest request) {
        List<CakeIngredient> cakeIngredients = cakeIngredientRepository.findAll();
        return new GetAllCakeIngredientsResponse(cakeIngredients);
    }
}
