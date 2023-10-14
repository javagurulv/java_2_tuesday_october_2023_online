package database;

import domain.Client;

import java.util.List;

public interface Database {
    void addClient(Client client);

    void removeClient(Client client);

    List<Client> getAllClients();

    void saveClient(List<Client> clients);

}
