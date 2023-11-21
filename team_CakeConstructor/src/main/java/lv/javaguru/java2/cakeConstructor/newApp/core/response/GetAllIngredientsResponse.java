package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;

public class GetAllIngredientsResponse extends CoreResponse{
    private List<Ingredient> ingredients;

    public GetAllIngredientsResponse(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }


}
