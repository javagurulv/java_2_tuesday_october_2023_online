package lv.avangardteen.core.responce;

import lv.avangardteen.core.domain.*;

import java.util.List;

public class OrderResponse extends CoreResponse{
    Long idOrder;
    Client client;
    UserSizes userSizes;
    Wheelchair wheelchair;
    List<Components> listComponents;

    public OrderResponse(List<CoreError> errors) {
        super(errors);
    }
    public OrderResponse() {}

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public UserSizes getUserSizes() {
        return userSizes;
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public void setUserSizes(UserSizes userSizes) {
        this.userSizes = userSizes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Components> getListComponents() {
        return listComponents;
    }

    public void setListComponents(List<Components> listComponents) {
        this.listComponents = listComponents;
    }
}
