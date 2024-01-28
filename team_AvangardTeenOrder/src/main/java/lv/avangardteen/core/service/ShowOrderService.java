package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
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

        Wheelchair wheelchair = wheelchairDB.getWheelchair(request.getId());

        List<WheelchairComponents> wheelchairComponent = wComponentsDB.getChooseComponents(wheelchair);

        ShowOrderResponse response = new ShowOrderResponse();
        response.setWheelchair(wheelchair);
        response.setWheelchairComponents(wheelchairComponent);

        response.setPriceWheelchair(wheelchairDB.getPrice(request.getId()));
        response.setPriceComponents(getPriceComponents(wheelchairComponent));
        response.setPriceOrder(wheelchairDB.getPrice(request.getId()) + getPriceComponents(wheelchairComponent));

        return response;
    }

    private Double getPriceComponents(List<WheelchairComponents> wheelchairComponent) {
        Double priceComponents = 0.0;
        for(WheelchairComponents wheelchairComponents : wheelchairComponent) {
            priceComponents = priceComponents + wheelchairComponents.getPriceComponent();
        }
        return priceComponents;
    }
}
