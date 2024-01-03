package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class RegisterClientRequest {

	private String firstName;
	private String lastName;
	private String personalCode;

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
}
