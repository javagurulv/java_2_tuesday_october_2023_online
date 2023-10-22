package fitness_club.core.responses;

import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.CoreResponse;
import fitness_club.core.domain.Client;

import java.util.List;

public class ClientResponse extends CoreResponse {

    private Client newClient;

    public ClientResponse(List<CoreError> errors) {
        super(errors);
    }

    public ClientResponse(Client newClient) {
        this.newClient = newClient;
    }

    public Client getNewClient() {
        return newClient;
    }
}
