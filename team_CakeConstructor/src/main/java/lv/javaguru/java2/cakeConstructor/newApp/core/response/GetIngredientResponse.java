package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;

public class GetIngredientResponse extends CoreResponse {

	private Ingredient ingredient;

	public GetIngredientResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetIngredientResponse(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

}
