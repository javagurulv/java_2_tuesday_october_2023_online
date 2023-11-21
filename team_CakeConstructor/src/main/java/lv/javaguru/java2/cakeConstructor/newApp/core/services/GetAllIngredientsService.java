package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;

import java.util.List;

public class GetAllIngredientsService {

    private Database database;

    public GetAllIngredientsService(Database database){
        this.database=database;
    }

    public GetAllIngredientsResponse execute(GetAllIngredientsRequest request){
        List<Ingredient> ingredients = database.getAllIngredients();
        return new GetAllIngredientsResponse(ingredients);
    }
}
