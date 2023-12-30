package fitness_club.core.responses;

import fitness_club.core.domain.Client;

import java.util.List;

public class RegisterClientResponse extends CoreResponse {

    private Client newClient;

    public RegisterClientResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegisterClientResponse(Client newClient) {
        this.newClient = newClient;
    }

    public Client getNewClient() {
        return newClient;
    }
}
