package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.AddClientResponse;

import java.util.List;

public class ChangeClientAgeGroupService {

    private Database database;

    public ChangeClientAgeGroupService(Database database) {
        this.database = database;
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
