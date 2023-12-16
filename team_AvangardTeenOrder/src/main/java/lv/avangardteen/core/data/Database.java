package lv.avangardteen.core.data;

import lv.avangardteen.core.dto.*;
import lv.avangardteen.core.service.WheelchairComponent;

import java.util.List;

public interface Database {

    List<Client> getClients();
    List<Wheelchair> getUserWheelchair();
    List<UserSizes> getUserSizesOrders();
    List<WheelchairComponent> getUserChooseComponents();

    void addUser(Client client);
    void addUserSize(UserSizes userSizes);
    void addWheelchair(Wheelchair wheelchair);
    void addWheelchairComponents(WheelchairComponent wheelchairComponent);

    void updateUser(Long id, Client client);
    void updateUserSize(Long id, UserSizes userSizes);
    void updateWheelchair(Long id, Wheelchair wheelchair);
    void updateWheelchairComponents(Long id, WheelchairComponent wheelchairComponent);

    boolean deleteOrder(Long id);
    Client getClient(Long id);

    UserSizes getUserSize(Long id);
    Wheelchair getWheelchair(Long id);
    WheelchairComponent getWheelchairComponents(Long id);

    List<Client> findBySurname(String surname);
    List<Client> findBySurnameAndAddress(String surname, String address);
}
