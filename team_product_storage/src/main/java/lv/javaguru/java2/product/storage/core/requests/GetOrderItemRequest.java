package lv.javaguru.java2.product.storage.core.requests;

public class GetOrderItemRequest {

	private Long Id;

	public GetOrderItemRequest() {
	}

	public GetOrderItemRequest(Long id) {
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
