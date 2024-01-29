package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class GetCakeRequest {

	private Long id;

	public GetCakeRequest() { }

	public GetCakeRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
