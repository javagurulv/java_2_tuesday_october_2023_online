package lv.javaguru.java2.product.storage.core.responses;

import lv.javaguru.java2.product.storage.core.domain.Order;

import java.util.List;

public class GetAllOrdersResponse extends CoreResponse {

	private List<Order> orders;

	public GetAllOrdersResponse(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}
}
