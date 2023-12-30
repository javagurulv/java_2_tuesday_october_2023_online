package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Customer;

import java.util.List;

public class RegisterCustomerResponse extends CoreResponse {

	private Customer newCustomer;

	public RegisterCustomerResponse(List<CoreError> errors) {
		super(errors);
	}

	public RegisterCustomerResponse(Customer newCustomer) {
		this.newCustomer = newCustomer;
	}

	public Customer getNewCustomer() {
		return newCustomer;
	}

}