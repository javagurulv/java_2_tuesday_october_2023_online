package lv.javaguru.java2.library.core.requests;

public class RegisterReaderRequest {

	private String firstName;
	private String lastName;

	public RegisterReaderRequest() { }

	public RegisterReaderRequest(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
