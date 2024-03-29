package lv.javaguru.java2.lessoncode.book.app.core.requests;

public class UpdateReaderRequest {

	private Long id;
	private String newFirstName;
	private String newLastName;
	private String newPersonalCode;

	public UpdateReaderRequest() { }

	public UpdateReaderRequest(Long id, String newFirstName, String newLastName, String newPersonalCode) {
		this.id = id;
		this.newFirstName = newFirstName;
		this.newLastName = newLastName;
		this.newPersonalCode = newPersonalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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