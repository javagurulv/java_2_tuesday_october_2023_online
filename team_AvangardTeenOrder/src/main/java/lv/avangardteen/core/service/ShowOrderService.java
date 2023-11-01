package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.DeleteOrderResponse;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.List;


public class ShowOrderService {
    private Database database;
    private ShowOrderValidator validator;

    public ShowOrderService(Database database, ShowOrderValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public ShowOrderResponse execute(ShowOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ShowOrderResponse(errors);
        }

        Client client = database.getClient(request.getId());
        return new ShowOrderResponse(client);
    }
}
