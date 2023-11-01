package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.UserSizes;
import lv.avangardteen.Wheelchair;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
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

        clientResponse.getClient().setUserSizes(new UserSizes(request.getBackLength(),
                request.getPelvisWidth(),
                request.getShinLength(),
                request.getThighLength()));

        clientResponse.getClient().setWheelchair(new Wheelchair(new UserSizes(request.getBackLength(),
                request.getPelvisWidth(),
                request.getShinLength(),
                request.getThighLength())));


        clientResponse.getClient().setWheelchairComponents(new WheelchairComponent());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexWheelFront());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexWheelBack());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexBrakeChoose());
        clientResponse.getClient().getWheelchairComponents().addComponents(request.getIndexArmrestChoose());

        clientResponse.getClient().setPriseOrder(clientResponse.getClient().getWheelchairComponents().getPriceComponent()
                + clientResponse.getClient().getWheelchair().getPriceWheelchair());

        database.addUser(clientResponse.getClient());
        System.out.println("Ваш номер заказа" + clientResponse.getClient().getId());

        return new ClientResponse(clientResponse.getClient());
    }
}
