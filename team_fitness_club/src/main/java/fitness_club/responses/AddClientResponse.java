package fitness_club.responses;

import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.CoreResponse;
import fitness_club.domain.Client;

import java.util.List;

public class AddClientResponse extends CoreResponse {

    private Client newClient;

    public AddClientResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddClientResponse(Client newClient) {
        this.newClient = newClient;
    }

    public Client getNewClient() {
        return newClient;
    }
}
