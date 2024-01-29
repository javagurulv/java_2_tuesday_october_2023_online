package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class DeleteIngredientRequest {

	private Long id;

	public DeleteIngredientRequest() { }

	public DeleteIngredientRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
