package fitness_club.core.services;
import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.ClientAndWorkoutRequest;
import fitness_club.core.responses.ClientAndWorkoutResponse;

public class AddClientService {

    private Database database;

    public  AddClientService(Database database) {
        this.database = database;
    }

    public ClientAndWorkoutResponse execute(ClientAndWorkoutRequest request) {
        Client client = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode(), request.getWorkout());
        database.addClient(client);
        return new ClientAndWorkoutResponse(client);
    }
}
