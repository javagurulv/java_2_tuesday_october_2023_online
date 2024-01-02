package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Client;
import org.hibernate.query.Query;

import java.util.List;

public interface Database {

    List<Client> getClients();

    void addUser(Client client);

    void updateUser(Long id, Client client);

    boolean deleteClientByOrderId(Long id);

    Client getClientByOrderId(Long idOrder);

    Client findBySurnameAndPersonalCode(String surname, Long personalCode);

    void setOrderId(Long orderId);

    Query getIdClient();
}
