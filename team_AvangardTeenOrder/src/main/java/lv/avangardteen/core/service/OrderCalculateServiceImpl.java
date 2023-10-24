package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.UserSizes;
import lv.avangardteen.Wheelchair;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.data.DataOrders;


public class OrderCalculateServiceImpl{
    private DataOrders dataOrders;
    private WheelchairComponent wheelchairComponent;

    public OrderCalculateServiceImpl(DataOrders dataOrders) {
        this.dataOrders = dataOrders;
    }


    public Client execute(ClientRequest request) {
        Client clientResponse = new Client();
        clientResponse.setId(request.getId());
        clientResponse.setNameSurname(request.getNameSurname());
        clientResponse.setUserAddress(request.getUserAddress());
        clientResponse.setPhoneNumber(request.getPhoneNumber());

        clientResponse.setUserSizes(new UserSizes(request.getBackLength(),
                request.getPelvisWidth(),
                request.getShinLength(),
                request.getThighLength()));

        clientResponse.setWheelchair(new Wheelchair(new UserSizes(request.getBackLength(),
                request.getPelvisWidth(),
                request.getShinLength(),
                request.getThighLength())));

        WheelchairComponent wheelchairComponent = new WheelchairComponent();
        wheelchairComponent.addComponents(request.getWheelFront());
        wheelchairComponent.addComponents(request.getWheelBack());
        wheelchairComponent.addComponents(request.getArmrestChoose());
        wheelchairComponent.addComponents(request.getBrakeChoose());

        clientResponse.setWheelchairComponents(wheelchairComponent);


        clientResponse.setPriseOrder(wheelchairComponent.getPriceComponent() + clientResponse.getWheelchair().getPriceWheelchair());
         dataOrders.addUser(clientResponse);

        return clientResponse;
    }
}
