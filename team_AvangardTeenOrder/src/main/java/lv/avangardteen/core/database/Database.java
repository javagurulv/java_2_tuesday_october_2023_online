package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.*;
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

    boolean deleteClientById(Long id);

    Client getClient(Long id);
    UserSizes getUserSize(Long id);
    Wheelchair getWheelchair(Long id);
    WheelchairComponent getWheelchairComponents(Long id);


    Client findBySurnameAndPersonalCode(String surname, Long personalCode);
}
