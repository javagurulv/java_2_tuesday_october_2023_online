package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.data.DataOrders;


public class ShowOrderService {
    DataOrders dataOrders;

    public ShowOrderService(DataOrders dataOrders) {
        this.dataOrders = dataOrders;
    }

    public ShowOrderResponse execute(ShowOrderRequest request) {
        Client client = dataOrders.getClient(request.getId());
        System.out.println(client.toString());
        return new ShowOrderResponse(client);
    }
}
