package fitness_club.core.responses;

import fitness_club.core.domain.Client;
import fitness_club.data_vlidation.CoreResponse;

import java.util.List;

public class GetAllClientsResponse extends CoreResponse {

    private List<Client> clients;

    public GetAllClientsResponse(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
}
