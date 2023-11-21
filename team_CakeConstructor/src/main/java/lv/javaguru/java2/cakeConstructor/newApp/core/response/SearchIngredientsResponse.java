package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;

public class SearchIngredientsResponse extends CoreResponse {

    private List <Ingredient> ingredients;


    public SearchIngredientsResponse(List<Ingredient> ingredients, List<CoreError> errors){
        super(errors);
        this.ingredients = ingredients;

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}
