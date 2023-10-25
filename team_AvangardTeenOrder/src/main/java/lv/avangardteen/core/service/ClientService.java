package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.UserSizes;
import lv.avangardteen.Wheelchair;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;

import java.util.List;


public class ClientService {
    private DataOrders dataOrders;
    private ClientOrderValidator validator;

    public ClientService(DataOrders dataOrders, ClientOrderValidator validator) {
        this.dataOrders = dataOrders;
        this.validator = validator;
    }


    public ClientResponse execute(ClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()) {
            new ClientResponse(errors);
        }


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

        WheelchairComponent wheelchairComponent = new WheelchairComponent();
        wheelchairComponent.addComponents(request.getWheelFront());
        wheelchairComponent.addComponents(request.getWheelBack());
        wheelchairComponent.addComponents(request.getArmrestChoose());
        wheelchairComponent.addComponents(request.getBrakeChoose());

        clientResponse.getClient().setWheelchairComponents(wheelchairComponent);


        clientResponse.getClient().setPriseOrder(wheelchairComponent.getPriceComponent() + clientResponse.getClient().getWheelchair().getPriceWheelchair());
        dataOrders.addUser(clientResponse.getClient());
        System.out.println("Ваш номер заказа" + dataOrders.getId());

        return new ClientResponse(clientResponse.getClient()) ;
    }
}
