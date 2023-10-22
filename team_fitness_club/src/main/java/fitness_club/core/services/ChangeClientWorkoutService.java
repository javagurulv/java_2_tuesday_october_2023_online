package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.responses.AddClientResponse;

import java.util.List;

public class ChangeClientWorkoutService {

    private Database database;

    public ChangeClientWorkoutService(Database database) {
        this.database = database;
    }

    public AddClientResponse execute(ChangeClientWorkoutsRequest request) {
        Client clientToChangeWorkout = new Client(request.getPersonalCode());
        List<Client> clients = database.getAllClients();
        clients.stream()
                .filter(client -> client.getPersonalCode().equals(request.getPersonalCode()))
                .findFirst()
                .ifPresent(client -> client.setWorkouts(request.getWorkout()));
        return new AddClientResponse(clientToChangeWorkout);
    }
}
