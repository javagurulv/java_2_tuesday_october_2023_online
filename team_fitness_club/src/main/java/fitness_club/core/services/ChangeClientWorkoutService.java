package fitness_club.core.services;
import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.ClientAndWorkoutRequest;
import fitness_club.core.requests.ClientRequest;
import fitness_club.core.responses.ClientAndWorkoutResponse;

import java.util.List;

public class ChangeClientWorkoutService {

    private Database database;

    public ChangeClientWorkoutService(Database database) {
        this.database = database;
    }

    public ClientAndWorkoutResponse execute(ClientAndWorkoutRequest request) {
        Client clientToChangeWorkout = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode());
        List<Client> clients = database.getAllClients();
        for (Client client: clients) {
            if (client.equals(clientToChangeWorkout)) {
                client.setWorkouts(request.getWorkout());
                database.saveClient(clients);
                break;
            }
        }
        return new ClientAndWorkoutResponse(clientToChangeWorkout);
    }
}
