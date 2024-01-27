package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetOrderRequest {

	private Long Id;

	public GetOrderRequest() { }

	public GetOrderRequest(Long id) {
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
}
