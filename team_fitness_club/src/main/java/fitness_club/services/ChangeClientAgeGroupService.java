package fitness_club.services;

import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;

import java.util.List;

public class ChangeClientAgeGroupService {

    private Database database;

    public ChangeClientAgeGroupService(Database database) {
        this.database = database;
    }

    public void changeClientAgeGroup(String personalCode, ClientAgeGroups clientAgeGroups) {
        List<Client> clients = database.getAllClients();
        clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst()
                .ifPresent(client -> client.setClientAgeGroup(clientAgeGroups));
    }
}
