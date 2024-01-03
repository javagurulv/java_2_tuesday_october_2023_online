package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;

public class UpdateIngredientResponse extends CoreResponse {

	private Ingredient updatedIngredient;

	public UpdateIngredientResponse(List<CoreError> errors) {
		super(errors);
	}

	public UpdateIngredientResponse(Ingredient updatedIngredient) {
		this.updatedIngredient = updatedIngredient;
	}

	public Ingredient getUpdatedIngredient() {
		return updatedIngredient;
	}

}