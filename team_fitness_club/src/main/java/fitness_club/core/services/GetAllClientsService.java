package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllClientsService {

   @Autowired
   private Database database;

    public GetAllClientsResponse execute(GetAllClientsRequest request) {
        List<Client> clients = database.getAllClients();
        return new GetAllClientsResponse(clients);
    }
}
