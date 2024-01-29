package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;

import java.util.List;

public class GetCakeIngredientResponse extends CoreResponse {

	private CakeIngredient cakeIngredient;

	public GetCakeIngredientResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetCakeIngredientResponse(CakeIngredient cakeIngredient) {
		this.cakeIngredient = cakeIngredient;
	}

	public CakeIngredient getCakeIngredient() {
		return cakeIngredient;
	}

}
