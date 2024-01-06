package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import org.hibernate.query.Query;

import java.util.List;

public interface Database {

    List<Client> getClients();

    Long addUser(Client client);

    void updateUser(Long id, Client client);

    boolean deleteClientByOrderId(Long id);

    Client getClientById(Long id);

    Client findBySurnameAndPersonalCode(String surname, Long personalCode);

    void setOrderId(Long orderId);

    Query getIdClient();
}
