package fitness_club.core.database;

import fitness_club.core.domain.Client;

import java.util.List;

public interface Database {
    void addClient(Client client);

    void removeClient(String personalCode);

    List<Client> getAllClients();

    void saveClient(List<Client> clients);

}