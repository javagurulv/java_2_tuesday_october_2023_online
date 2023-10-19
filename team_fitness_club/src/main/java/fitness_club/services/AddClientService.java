package fitness_club.services;

import fitness_club.data_vlidation.AddClientValidator;
import fitness_club.data_vlidation.CoreError;
import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.requests.AddClientRequest;
import fitness_club.responses.AddClientResponse;

import java.util.List;

public class AddClientService {

    private Database database;

    private AddClientValidator validator;

    public AddClientService(Database database,
                            AddClientValidator validator) {
        this.validator = validator;
        this.database = database;
    }

    public AddClientResponse execute(AddClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty())
            return new AddClientResponse(errors);
        Client client = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode(), request.getClientAgeGroup(), request.getWorkout());
        database.addClient(client);
        return new AddClientResponse(client);
    }

}
