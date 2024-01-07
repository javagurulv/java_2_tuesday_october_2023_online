package avangardteen.java2app.data;

import avangardteen.java2app.domen.Client;

import java.util.List;

public interface DatabaseClient {
    void addClient (Client client);
    void deleteClient (int id);
    List<Client> getAllClients();
    List<Client> findClientBySecondName(String secondName);
}
