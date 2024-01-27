package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;

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
