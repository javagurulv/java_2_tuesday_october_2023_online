package lv.avangardteen.data;

import lv.avangardteen.Client;

import java.util.List;

public interface Database {

    List<Client> getClients();
    void addUser(Client client);
    boolean deleteUser(long id);
    Client getClient(long id);
    List<Client> findBySurname(String surname);
    List<Client> findBySurnameAndAddress(String surname, String address);
}
