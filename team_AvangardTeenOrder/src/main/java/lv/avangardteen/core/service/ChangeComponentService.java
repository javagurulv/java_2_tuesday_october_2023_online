package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;

import java.util.List;

public class ChangeComponentService {
    DataOrders dataOrders;
    private ChooseComponentValidator validator;

    public ChangeComponentService(DataOrders dataOrders, ChooseComponentValidator validator) {
        this.dataOrders = dataOrders;
        this.validator = validator;
    }

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeComponentResponse(errors);
        }
        Client client = dataOrders.getClient(request.getId());
        ChangeComponentResponse response = new ChangeComponentResponse(client);

        WheelchairComponent components = response.getClient().getWheelchairComponents();

        components.addComponents(request.getWheelFrontChoose());
        components.addComponents(request.getWheelBackChoose());
        components.addComponents(request.getBrakeChoose());
        components.addComponents(request.getArmrestChoose());
        response.getClient().setWheelchairComponents(components);
        double priceComponent = response.getClient().getWheelchairComponents().getPriceComponent();
        double priseWheelchair = response.getClient().getWheelchair().getPriceWheelchair();
        response.getClient().setPriseOrder(priseWheelchair + priceComponent);

        return new ChangeComponentResponse(client);

    }
}
