package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;

import java.util.List;


public class GetAllClientsService {

    private Database database;

    public GetAllClientsService(Database database) {
        this.database = database;
    }

    public GetAllClientsResponse execute(GetAllClientsRequest request) {
        List<Client> clients = database.getAllClients();
        return new GetAllClientsResponse(clients);
    }
}
