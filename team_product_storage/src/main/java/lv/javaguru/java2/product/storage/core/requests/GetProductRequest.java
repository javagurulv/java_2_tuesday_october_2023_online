package lv.javaguru.java2.product.storage.core.requests;

public class GetProductRequest {

	private Long id;

	public GetProductRequest() { }

	public GetProductRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
