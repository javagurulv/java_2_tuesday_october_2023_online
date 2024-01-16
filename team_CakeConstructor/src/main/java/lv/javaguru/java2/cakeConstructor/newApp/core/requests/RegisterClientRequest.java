package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class RegisterClientRequest {

	private String firstName;
	private String lastName;
	private String personalCode;

	public RegisterClientRequest() {
	}

	public RegisterClientRequest(String firstName, String lastName, String personalCode) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.personalCode = personalCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}
}
