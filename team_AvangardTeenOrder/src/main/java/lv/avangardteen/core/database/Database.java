package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.*;
import lv.avangardteen.core.service.WheelchairComponent;

import java.util.List;

public interface Database {

    List<Client> getClients();

    void addUser(Client client);

    void updateUser(Long id, Client client);

    boolean deleteClientById(Long id);

    Client getClient(Long id);

    Client findBySurnameAndPersonalCode(String surname, Long personalCode);
}
