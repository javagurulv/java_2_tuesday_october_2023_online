package fitness_club.services;

import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.requests.ClientAndWorkoutRequest;
import fitness_club.responses.ClientAndWorkoutResponse;

public class AddClientService {

    private Database database;

    public AddClientService(Database database) {
        this.database = database;
    }

    public ClientAndWorkoutResponse execute(ClientAndWorkoutRequest request) {
        Client client = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode(), request.getClientAgeGroup(), request.getWorkout());
        database.addClient(client);
        return new ClientAndWorkoutResponse(client);
    }
}
