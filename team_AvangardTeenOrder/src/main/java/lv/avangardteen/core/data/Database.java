package lv.avangardteen.core.data;

import lv.avangardteen.core.dto.Client;

import java.util.List;

public interface Database {

    List<Client> getClients();
    void addUser(Client client);
    boolean deleteUser(Long id);
    Client getClient(Long id);
    List<Client> findBySurname(String surname);
    List<Client> findBySurnameAndAddress(String surname, String address);
}