package lv.avangardteen.core.service;

import lv.avangardteen.dto.Client;
import lv.avangardteen.dto.WheelchairComponent;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;

import java.util.List;

public class ChangeComponentService {
    private Database database;
    private DataComponents dataComponents;
    private ChooseComponentValidator validator;


    public ChangeComponentService(Database database, DataComponents dataComponents, ChooseComponentValidator validator) {
        this.database = database;
        this.dataComponents = dataComponents;
        this.validator = validator;
    }

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        return  (!errors.isEmpty())
            ? new ChangeComponentResponse(errors)
            : getResponse(request);

    }

    private ChangeComponentResponse getResponse(ChangeComponentRequest request) {
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
