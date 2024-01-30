package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;

import java.util.List;

public class GetAllCakeIngredientsResponse extends CoreResponse {

    private List<CakeIngredient> cakeIngredients;

    public GetAllCakeIngredientsResponse(List<CakeIngredient> cakeIngredients) {
        this.cakeIngredients = cakeIngredients;
    }

    public List<CakeIngredient> getCakeIngredients() {
        return cakeIngredients;
    }

}
