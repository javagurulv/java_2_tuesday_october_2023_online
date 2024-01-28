package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetCakeIngredientRequest {

	private Long Id;

	public GetCakeIngredientRequest() { }

	public GetCakeIngredientRequest(Long id) {
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
