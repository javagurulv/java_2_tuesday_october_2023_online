package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetOrderRequest {

	private Long id;

	public GetOrderRequest() { }

	public GetOrderRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
