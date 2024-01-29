package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Order;

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
