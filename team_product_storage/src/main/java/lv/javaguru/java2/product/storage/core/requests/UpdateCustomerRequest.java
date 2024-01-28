package lv.javaguru.java2.product.storage.core.requests;


public class UpdateCustomerRequest {

	private Long id;
	private String newCustomerName;
	private String newRegistrationCode;

	public UpdateCustomerRequest() {
	}

	public UpdateCustomerRequest(Long id, String newCustomerName, String newRegistrationCode) {
		this.id = id;
		this.newCustomerName = newCustomerName;
		this.newRegistrationCode = newRegistrationCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewCustomerName() {
		return newCustomerName;
	}

	public void setNewCustomerName(String newCustomerName) {
		this.newCustomerName = newCustomerName;
	}

	public String getNewRegistrationCode() {
		return newRegistrationCode;
	}

	public void setNewRegistrationCode(String newRegistrationCode) {
		this.newRegistrationCode = newRegistrationCode;
	}
}