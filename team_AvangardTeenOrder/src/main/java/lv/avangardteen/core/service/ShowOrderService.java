package lv.avangardteen.core.service;

import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;
import lv.avangardteen.dto.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import lv.avangardteen.data.Database;

import java.util.List;

@DIComponent
public class ShowOrderService {
    @DIDependency
    private Database database;
    @DIDependency
    private ShowOrderValidator validator;

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
