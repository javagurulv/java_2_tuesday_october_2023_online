package lv.avangardteen.core.service;

import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;
import lv.avangardteen.dto.Client;
import lv.avangardteen.dto.UserSizes;
import lv.avangardteen.dto.Wheelchair;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientOrderValidator;
import lv.avangardteen.data.Database;

import java.util.List;

@DIComponent
public class ClientService {

    @DIDependency
    private Database database;
    @DIDependency
    private ClientOrderValidator validator;
    @DIDependency
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
