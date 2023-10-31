package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;

import java.util.List;

public class ChangeComponentService {
    DataOrders dataOrders;
    DataComponents dataComponents = new DataComponents();
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

        WheelchairComponent component = new WheelchairComponent();

        component.addComponents(request.getWheelFrontChoose());
        component.addComponents(request.getWheelBackChoose());
        component.addComponents(request.getArmrestChoose());
        component.addComponents(request.getBrakeChoose());
        client.setWheelchairComponents(component);

        double priceComponent = client.getWheelchairComponents().getPriceComponent();
        double priseWheelchair = client.getWheelchair().getPriceWheelchair();
        client.setPriseOrder(priseWheelchair + priceComponent);


        return new ChangeComponentResponse(client);

    }
}
