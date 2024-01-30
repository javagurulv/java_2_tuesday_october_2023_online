package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class UpdateIngredientRequest {

	private Long id;
	private String newType;
	private String newTaste;

	public UpdateIngredientRequest() { }

	public UpdateIngredientRequest(Long id, String newType, String newTaste) {
		this.id = id;
		this.newType = newType;
		this.newTaste = newTaste;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public String getNewTaste() {
		return newTaste;
	}

	public void setNewTaste(String newTaste) {
		this.newTaste = newTaste;
	}
}