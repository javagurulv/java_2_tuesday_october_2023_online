package lv.avangardteen.core.service;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import lv.avangardteen.core.data.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShowOrderService {
    @Autowired
    private Database database;
    @Autowired
    private ShowOrderValidator validator;

    public ShowOrderResponse execute(ShowOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ShowOrderResponse(errors)
                : getShowOrderResponse(request);
    }

    private ShowOrderResponse getShowOrderResponse(ShowOrderRequest request) {
        Client client = database.getClient(request.getId());
        UserSizes userSizes = database.getUserSize(request.getId());
        Wheelchair wheelchair = database.getWheelchair(request.getId());
        WheelchairComponent wheelchairComponent = database.getWheelchairComponents(request.getId());
        ShowOrderResponse response = new ShowOrderResponse();
        response.setClient(client);
        response.setUserSizes(userSizes);
        response.setWheelchair(wheelchair);
        response.setWheelchairComponent(wheelchairComponent);

        return response;
    }
}
