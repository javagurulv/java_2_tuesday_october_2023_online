package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.Workouts;
import fitness_club.requests.ChangeWorkoutRequest;
import fitness_club.requests.ClientAndWorkoutRequest;
import fitness_club.responses.ClientAndWorkoutResponse;

import java.util.List;

public class ChangeClientWorkoutService {

    private Database database;

    public ChangeClientWorkoutService(Database database) {
        this.database = database;
    }

    public void changeClientWorkout(String personalCode, Workouts workout) {
        Client clientToChangeWorkout = new Client(personalCode);
        List<Client> clients = database.getAllClients();
        for (Client client: clients) {
            if (client.equals(clientToChangeWorkout)) {
                client.setWorkouts(workout);
                database.saveClient(clients);
                break;
            }
        }
    }

    public ClientAndWorkoutResponse execute(ChangeWorkoutRequest request) {
        Client clientToChangeWorkout = new Client(request.getPersonalCode());
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
