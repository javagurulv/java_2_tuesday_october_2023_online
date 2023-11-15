package lv.avangardteen.core.service;

import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;
import lv.avangardteen.dto.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;

import java.util.List;

@DIComponent
public class ChangeComponentService {
    @DIDependency
    private Database database;
    @DIDependency
    private ChooseComponentValidator validator;

    public ChangeComponentResponse execute(ChangeComponentRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ChangeComponentResponse(errors)
                : getResponse(request);

    }

    private ChangeComponentResponse getResponse(ChangeComponentRequest request) {
        Client client = database.getClient(request.getId());

        client.setWheelchairComponents(request.getWheelchairComponent());

        client.setPriseOrder(client.getWheelchairComponents().countPriceOrder());

        return new ChangeComponentResponse(client);
    }
}
