package lv.javaguru.java2.cakeConstructor.newApp.matchers;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import org.mockito.ArgumentMatcher;

public class IngredientMatcher implements ArgumentMatcher<Ingredient> {
	private String type;
	private String taste;

	public IngredientMatcher(String type, String taste) {
		this.type = type;
		this.taste = taste;
	}

	@Override
	public boolean matches(Ingredient ingredient) {
		return ingredient.getType().equals(type)
				&& ingredient.getTaste().equals(taste);
	}
}