package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.OrderItem;

import java.util.List;

public class GetOrderItemResponse extends CoreResponse {

	private OrderItem orderItem;

	public GetOrderItemResponse(List<CoreError> errors) {
		super(errors);
	}

	public GetOrderItemResponse(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

}
