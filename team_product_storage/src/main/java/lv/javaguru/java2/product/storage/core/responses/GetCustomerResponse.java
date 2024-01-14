package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Customer;

import java.util.List;

public class GetCustomerResponse extends CoreResponse {

	private Customer customer;

	public GetCustomerResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetCustomerResponse(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

}
