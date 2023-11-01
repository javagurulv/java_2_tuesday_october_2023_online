package lv.avangardteen.data;

import lv.avangardteen.Client;

import java.util.List;

public interface Database {

    List<Client> getClients();
    void addUser(Client client);
    void deleteUser(long id);
    Client getClient(long id);
}
