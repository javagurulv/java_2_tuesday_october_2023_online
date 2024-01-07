package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class RegisterReaderRequest {

	private String firstName;
	private String lastName;
	private String personalCode;

	public RegisterReaderRequest() {
	}

	public RegisterReaderRequest(String firstName, String lastName, String personalCode) {
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
