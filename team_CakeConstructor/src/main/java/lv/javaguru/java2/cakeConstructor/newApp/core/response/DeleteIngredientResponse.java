package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;


import java.util.List;

public class DeleteIngredientResponse extends CoreResponse {

	private Ingredient deletedIngredient;

	public DeleteIngredientResponse(List<CoreError> errors) {
		super(errors);
	}

	public DeleteIngredientResponse(Ingredient deletedIngredient) {
		this.deletedIngredient = deletedIngredient;
	}

	public Ingredient getDeletedIngredient() {
		return deletedIngredient;
	}

}
