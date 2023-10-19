package fitness_club.responses;

import fitness_club.domain.Client;

public class ClientAndWorkoutResponse {

    private Client newClient;

    public ClientAndWorkoutResponse(Client newClient) {
        this.newClient = newClient;
    }

    public Client getNewClient() {
        return newClient;
    }
}
