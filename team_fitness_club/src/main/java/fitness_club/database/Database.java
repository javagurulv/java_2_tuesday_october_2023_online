package fitness_club.database;

import fitness_club.domain.Client;

import java.util.List;

public interface Database {
    void addClient(Client client);

    void removeClient(String personalCode);

    List<Client> getAllClients();

    void saveClient(List<Client> clients);

}
