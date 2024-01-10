package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Customer;
import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public class UpdateCustomerResponse extends CoreResponse {

	private Customer updatedCustomer;

	public UpdateCustomerResponse(List<CoreError> errors) {
		super(errors);
	}

	public UpdateCustomerResponse(Customer updatedCustomer) {
		this.updatedCustomer = updatedCustomer;
	}

	public Customer getUpdatedCustomer() {
		return updatedCustomer;
	}

}