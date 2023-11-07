package lv.avangardteen.core.service;

import lv.avangardteen.dto.Client;
import lv.avangardteen.dto.UserSizes;
import lv.avangardteen.dto.Wheelchair;
import lv.avangardteen.dto.WheelchairComponent;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientOrderValidator;
import lv.avangardteen.data.Database;

import java.util.List;


public class ClientService {
    private Database database;
    private ClientOrderValidator validator;

    public ClientService(Database database, ClientOrderValidator validator) {
        this.database = database;
        this.validator = validator;
    }


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


        UserSizes userSizes = new UserSizes();
        userSizes.setPelvisWidth(request.getPelvisWidth());
        userSizes.setThighLength(request.getThighLength());
        userSizes.setBackHeight(request.getBackHeight());
        userSizes.setShinLength(request.getShinLength());
        clientResponse.getClient().setUserSizes(userSizes);

        clientResponse.getClient().setWheelchair(buildWheelchair(userSizes));


        clientResponse.getClient().setWheelchairComponents(new WheelchairComponent());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexWheelFront());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexWheelBack());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexBrakeChoose());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexArmrestChoose());

        clientResponse.getClient().setPriseOrder(clientResponse.getClient().getWheelchairComponents().getPriceComponent()
                + clientResponse.getClient().getWheelchair().getPriceWheelchair());

        database.addUser(clientResponse.getClient());

        return new ClientResponse(clientResponse.getClient());
    }

    private static Wheelchair buildWheelchair(UserSizes userSizes) {
        CalculateDimensionsWheelchair calculateDimensionsWheelchair = new CalculateDimensionsWheelchair(userSizes, new Wheelchair());
        return calculateDimensionsWheelchair.setDimensions(userSizes);
    }
}
