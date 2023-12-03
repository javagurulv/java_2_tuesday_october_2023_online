package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllIngredientsService {

    @Autowired private Database database;


    public GetAllIngredientsResponse execute(GetAllIngredientsRequest request){
        List<Ingredient> ingredients = database.getAllIngredients();
        return new GetAllIngredientsResponse(ingredients);
    }
}
