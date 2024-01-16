package lv.javaguru.java2.product.storage.core.requests;

public class DeleteProductRequest {

	private Long id;

	public DeleteProductRequest() { }

	public DeleteProductRequest(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
