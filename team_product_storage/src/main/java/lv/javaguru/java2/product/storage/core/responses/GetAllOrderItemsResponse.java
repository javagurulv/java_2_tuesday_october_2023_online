package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.OrderItem;

import java.util.List;

public class GetAllOrderItemsResponse extends CoreResponse {

	private List<OrderItem> orderItems;

	public GetAllOrderItemsResponse(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
}
