package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Customer;

import java.util.List;

public class DeleteCustomerResponse extends CoreResponse {

	private Customer deletedCustomer;

	public DeleteCustomerResponse(List<CoreError> errors) {
		super(errors);
	}

	public DeleteCustomerResponse(Customer deletedCustomer) {
		this.deletedCustomer = deletedCustomer;
	}

	public Customer getDeletedCustomer() {
		return deletedCustomer;
	}

}
