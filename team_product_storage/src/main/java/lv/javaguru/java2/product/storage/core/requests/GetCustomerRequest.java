package lv.javaguru.java2.product.storage.core.requests;

public class GetCustomerRequest {

	private Long id;

	public GetCustomerRequest() { }

	public GetCustomerRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
