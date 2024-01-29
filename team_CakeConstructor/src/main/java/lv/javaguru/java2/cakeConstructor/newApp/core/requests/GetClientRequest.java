package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetClientRequest {

	private Long id;

	public GetClientRequest() { }

	public GetClientRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
