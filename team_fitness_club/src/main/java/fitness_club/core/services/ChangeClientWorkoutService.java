package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.data_vlidation.ChangeClientWorkoutsValidator;
import fitness_club.data_vlidation.CoreError;

import java.util.List;

public class ChangeClientWorkoutService {

    private Database database;

    private ChangeClientWorkoutsValidator validator;

    public ChangeClientWorkoutService(Database database, ChangeClientWorkoutsValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public AddClientResponse execute(ChangeClientWorkoutsRequest request) {
        List<CoreError> errors = validator.validate(request);
        return errors.isEmpty()
                ? changeClientWorkoutsLogic(request)
                : buildErrorsResponse(errors);
    }

    private AddClientResponse buildErrorsResponse(List<CoreError> errors){
        return new AddClientResponse(errors);
    }

    private AddClientResponse changeClientWorkoutsLogic(ChangeClientWorkoutsRequest request){
        Client clientToChangeWorkout = new Client(request.getPersonalCode());
        List<Client> clients = database.getAllClients();
        clients.stream()
                .filter(client -> client.getPersonalCode().equals(request.getPersonalCode()))
                .findFirst()
                .ifPresent(client -> client.setWorkouts(request.getWorkout()));
        database.saveClient(clients);
        return new AddClientResponse(clientToChangeWorkout);
    }
}
