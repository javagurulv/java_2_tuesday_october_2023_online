package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class UpdateIngredientRequest {

	private Long Id;
	private String newType;
	private String newTaste;

	public UpdateIngredientRequest() { }


	public UpdateIngredientRequest(Long id, String newType, String newTaste) {
		Id = id;
		this.newType = newType;
		this.newTaste = newTaste;
	}

	public Long getId() { return Id; }
	public String getNewType() {
		return newType;
	}
	public String getNewTaste() {
		return newTaste;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}

	public void setNewTaste(String newTaste) {
		this.newTaste = newTaste;
	}
}