package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ShowOrderService {
    @Autowired
    private Database database;
    @Autowired
    private UserSizeDb userSizeDb;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private WComponentsDB wComponentsDB;
    @Autowired
    private ShowOrderValidator validator;

    public ShowOrderResponse execute(ShowOrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ShowOrderResponse(errors)
                : getShowOrderResponse(request);
    }

    private ShowOrderResponse getShowOrderResponse(ShowOrderRequest request) {
        Client client = database.getClientByOrderId(request.getId());
        UserSizes userSizes = userSizeDb.getUserSizeByOrderId(request.getId());
        Wheelchair wheelchair = wheelchairDB.getWheelchair(request.getId());
        List<WheelchairComponents> wheelchairComponent = wComponentsDB.getChooseComponents(request.getId());
        ShowOrderResponse response = new ShowOrderResponse();
        response.setClient(client);
        response.setUserSizes(userSizes);
        response.setWheelchair(wheelchair);
        response.setWheelchairComponents(wheelchairComponent);
        response.setPriceWheelchair(wheelchairDB.getPrice(request.getId()));
        response.setPriceComponents(wComponentsDB.getPriceComponents(request.getId()));
        response.setPriceOrder(wheelchairDB.getPrice(request.getId()) + wComponentsDB.getPriceComponents(request.getId()));

        return response;
    }
}
