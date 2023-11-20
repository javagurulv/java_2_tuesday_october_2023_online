package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class GetAllClientsService {

    @DIDependency private Database database;

    public GetAllClientsResponse execute(GetAllClientsRequest request) {
        List<Client> clients = database.getAllClients();
        return new GetAllClientsResponse(clients);
    }
}
