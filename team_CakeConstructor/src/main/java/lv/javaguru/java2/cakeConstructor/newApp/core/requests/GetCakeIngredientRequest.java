package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetCakeIngredientRequest {

	private Long id;

	public GetCakeIngredientRequest() { }

	public GetCakeIngredientRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
