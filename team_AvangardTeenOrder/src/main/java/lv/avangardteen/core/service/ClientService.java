package lv.avangardteen.core.service;

import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientOrderValidator;
import lv.avangardteen.core.data.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    @Autowired
    private Database database;
    @Autowired
    private ClientOrderValidator validator;
    @Autowired
    private CalculateDimensionsWheelchair dimensionsWheelchair;

    public ClientResponse execute(ClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new ClientResponse(errors)
                : getClientResponse(request);
    }

    private ClientResponse getClientResponse(ClientRequest request) {
        ClientResponse clientResponse = new ClientResponse(new Client());
        clientResponse.getClient().setNameSurname(request.getNameSurname());
        clientResponse.getClient().setUserAddress(request.getUserAddress());
        clientResponse.getClient().setPhoneNumber(request.getPhoneNumber());

        UserSizes userSizes = request.getUserSizes();
        clientResponse.getClient().setUserSizes(userSizes);
        clientResponse.getClient().setWheelchair(dimensionsWheelchair.setDimensions(userSizes));

        clientResponse.getClient().setWheelchairComponents(request.getWheelchairComponent());

        clientResponse.getClient().setPriseOrder(clientResponse.getClient().getWheelchairComponents().countPriceOrder());

        database.addUser(clientResponse.getClient());

        return new ClientResponse(clientResponse.getClient());
    }

}
