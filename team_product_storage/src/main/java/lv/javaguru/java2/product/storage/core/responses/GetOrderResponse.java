package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Order;

import java.util.List;

public class GetOrderResponse extends CoreResponse {

	private Order order;

	public GetOrderResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetOrderResponse(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

}
