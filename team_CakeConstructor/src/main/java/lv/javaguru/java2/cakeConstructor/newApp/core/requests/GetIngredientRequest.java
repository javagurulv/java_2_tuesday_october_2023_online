package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetIngredientRequest {

	private Long id;

	public GetIngredientRequest() { }

	public GetIngredientRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
