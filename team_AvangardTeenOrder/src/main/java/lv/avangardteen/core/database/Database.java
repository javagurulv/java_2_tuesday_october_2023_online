package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import org.hibernate.query.Query;

import java.util.List;

public interface Database {

    List<Client> getClients();

    void addUser(Client client);

    boolean deleteClientByOrderId(Long id);

    Client getClientById(Long id);

    Client findBySurnameAndPersonalCode(String surname, Long personalCode);

}
