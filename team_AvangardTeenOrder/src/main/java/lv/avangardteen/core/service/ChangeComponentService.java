package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.List;

public class ChangeComponentService {
    Database database;
    DataComponents dataComponents = new DataComponents();
    private ChooseComponentValidator validator;

    public ChangeComponentService(Database database, ChooseComponentValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeComponentResponse(errors);
        }

        Client client = database.getClient(request.getId());

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
