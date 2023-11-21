package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;

public class AddIngredientResponse extends CoreResponse{

    private Ingredient newIngredient;

    public AddIngredientResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddIngredientResponse(Ingredient newIngredient) {
        this.newIngredient = newIngredient;
    }

    public Ingredient getNewIngredient() {
        return newIngredient;
    }
}
