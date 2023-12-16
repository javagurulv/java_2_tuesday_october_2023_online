package lv.avangardteen.core.responce;

import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.Order;
import lv.avangardteen.core.dto.UserSizes;
import lv.avangardteen.core.dto.Wheelchair;
import lv.avangardteen.core.service.WheelchairComponent;

import java.util.List;


public class ShowOrderResponse extends CoreResponse {

    Client client;
    UserSizes userSizes;
    Wheelchair wheelchair;
    WheelchairComponent wheelchairComponent;

    public ShowOrderResponse(List<CoreError> errors) {
        super(errors);
    }

    public ShowOrderResponse() {}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public WheelchairComponent getWheelchairComponent() {
        return wheelchairComponent;
    }

    public void setWheelchairComponent(WheelchairComponent wheelchairComponent) {
        this.wheelchairComponent = wheelchairComponent;
    }
}
