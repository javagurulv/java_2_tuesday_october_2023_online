package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public class UpdateProductResponse extends CoreResponse {

	private Product updatedProduct;

	public UpdateProductResponse(List<CoreError> errors) {
		super(errors);
	}

	public UpdateProductResponse(Product updatedProduct) {
		this.updatedProduct = updatedProduct;
	}

	public Product getUpdatedProduct() {
		return updatedProduct;
	}

}