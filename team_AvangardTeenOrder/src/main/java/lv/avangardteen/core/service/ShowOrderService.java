package lv.avangardteen.core.service;

import lv.avangardteen.dto.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
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
        return (!errors.isEmpty())
                ? new ShowOrderResponse(errors)
                : getShowOrderResponse(request);
    }

    private ShowOrderResponse getShowOrderResponse(ShowOrderRequest request) {
        Client client = database.getClient(request.getId());
        return new ShowOrderResponse(client);
    }
}
