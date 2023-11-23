package fitness_club.core.responses;

import fitness_club.core.domain.Client;

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
