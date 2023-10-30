package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.data.DataOrders;

import java.util.List;


public class ShowOrderService {
    DataOrders dataOrders;
    ShowOrderValidator validator;

    public ShowOrderService(DataOrders dataOrders, ShowOrderValidator validator) {
        this.dataOrders = dataOrders;
        this.validator = validator;
    }

    public ShowOrderResponse execute(ShowOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ShowOrderResponse(errors);
        }

        Client client = dataOrders.getClient(request.getId());
        ShowOrderResponse response =  new ShowOrderResponse(client);
        return new ShowOrderResponse(dataOrders.getClient(request.getId()));

      //  return new ShowOrderResponse(dataOrders.getClient(toString()));

    }
}
