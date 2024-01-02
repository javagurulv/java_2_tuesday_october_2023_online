package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllClientsService {

   @Autowired
   private ClientRepository clientRepository;

    public GetAllClientsResponse execute(GetAllClientsRequest request) {
        List<Client> clients = clientRepository.getAllClients();
        return new GetAllClientsResponse(clients);
    }
}
