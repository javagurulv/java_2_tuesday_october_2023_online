package lv.avangardteen.core.service;

import lv.avangardteen.core.database.UserSizeRepository;
import lv.avangardteen.core.database.WheelchairComponentsRepository;
import lv.avangardteen.core.database.WheelchairRepository;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import lv.avangardteen.core.database.Database;
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
    private UserSizeRepository userSizeRepository;
    @Autowired
    private WheelchairRepository wheelchairRepository;
    @Autowired
    private WheelchairComponentsRepository componentsRepository;
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
        UserSizes userSizes = userSizeRepository.getUserSizeByOrderId(request.getId());
        Wheelchair wheelchair = wheelchairRepository.getWheelchair(request.getId());
        List<WheelchairComponents> wheelchairComponent = componentsRepository.getChooseComponents(request.getId());
        ShowOrderResponse response = new ShowOrderResponse();
        response.setClient(client);
        response.setUserSizes(userSizes);
        response.setWheelchair(wheelchair);
        response.setWheelchairComponents(wheelchairComponent);
        response.setPriceWheelchair(wheelchairRepository.getPrice(request.getId()));
        response.setPriceComponents(componentsRepository.getPriceComponents(request.getId()));
        response.setPriceOrder(wheelchairRepository.getPrice(request.getId()) + componentsRepository.getPriceComponents(request.getId()));

        return response;
    }
}
