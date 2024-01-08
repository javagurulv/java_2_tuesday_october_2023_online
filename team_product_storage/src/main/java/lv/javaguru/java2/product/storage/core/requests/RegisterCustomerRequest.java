package lv.javaguru.java2.product.storage.core.requests;

public class RegisterCustomerRequest {

	private String customerName;
	private String registrationCode;

	public RegisterCustomerRequest() {
	}

	public RegisterCustomerRequest(String customerName, String registrationCode) {
		this.customerName = customerName;
		this.registrationCode = registrationCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}
}


