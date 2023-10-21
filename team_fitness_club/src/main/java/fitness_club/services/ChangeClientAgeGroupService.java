package fitness_club.services;

import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.requests.ChangeClientAgeGroupRequest;
import fitness_club.responses.AddClientResponse;

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

    public AddClientResponse execute(ChangeClientAgeGroupRequest request) {
        Client clientToChangeAgeGroup = new Client(request.getPersonalCode());
        List<Client> clients = database.getAllClients();
        clients.stream()
                .filter(client -> client.getPersonalCode().equals(request.getPersonalCode()))
                .findFirst()
                .ifPresent(client -> client.setClientAgeGroup(request.getClientAgeGroup()));
        return new AddClientResponse(clientToChangeAgeGroup);
    }
}
