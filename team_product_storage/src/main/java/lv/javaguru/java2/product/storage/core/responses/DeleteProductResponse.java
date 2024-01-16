package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public class DeleteProductResponse extends CoreResponse {

	private Product deletedProduct;

	public DeleteProductResponse(List<CoreError> errors) {
		super(errors);
	}

	public DeleteProductResponse(Product deletedProduct) {
		this.deletedProduct = deletedProduct;
	}

	public Product getDeletedProduct() {
		return deletedProduct;
	}

}
