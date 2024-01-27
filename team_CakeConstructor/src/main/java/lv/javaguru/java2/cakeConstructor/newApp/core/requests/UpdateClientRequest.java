package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class UpdateClientRequest {

	private Long Id;
	private String newFirstName;
	private String newLastName;
	private String newPersonalCode;

	public UpdateClientRequest() { }

	public UpdateClientRequest(Long id, String newFirstName, String newLastName, String newPersonalCode) {
		Id = id;
		this.newFirstName = newFirstName;
		this.newLastName = newLastName;
		this.newPersonalCode = newPersonalCode;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNewFirstName() {
		return newFirstName;
	}

	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}

	public String getNewLastName() {
		return newLastName;
	}

	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

	public String getNewPersonalCode() {
		return newPersonalCode;
	}

	public void setNewPersonalCode(String newPersonalCode) {
		this.newPersonalCode = newPersonalCode;
	}
}