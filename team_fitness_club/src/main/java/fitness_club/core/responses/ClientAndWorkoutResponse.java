package fitness_club.core.responses;

import fitness_club.core.domain.Client;

public class ClientAndWorkoutResponse {

    private Client newClient;

    public ClientAndWorkoutResponse(Client newClient) {
        this.newClient = newClient;
    }

    public Client getNewClient() {
        return newClient;
    }
}
