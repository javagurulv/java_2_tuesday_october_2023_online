package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;

import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.DeleteOrderResponse;

import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.List;

public class DeleteOrderService {
    private Database database;
    private IdOrderValidator validator;

    public DeleteOrderService(Database database, IdOrderValidator validator) {

        this.database = database;
        this.validator = validator;
    }

    public DeleteOrderResponse execute(DeleteOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new DeleteOrderResponse(errors)
                : getDeleteOrderResponse(request);

    }

    private DeleteOrderResponse getDeleteOrderResponse(DeleteOrderRequest request) {
       boolean isOrderRemove = database.deleteUser(request.getId());
       return new DeleteOrderResponse(isOrderRemove);
    }
}
