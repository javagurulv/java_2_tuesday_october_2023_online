package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public class GetProductResponse extends CoreResponse {

	private Product product;

	public GetProductResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetProductResponse(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

}
