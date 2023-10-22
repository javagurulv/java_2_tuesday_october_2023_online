package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.data_vlidation.CoreError;

import java.util.List;

public class AddClientService {

    private Database database;

    private AddClientRequestValidator validator;

    public AddClientService(Database database,
                            AddClientRequestValidator validator) {
        this.validator = validator;
        this.database = database;
    }

    public AddClientResponse execute(AddClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        return errors.isEmpty()
                ? addNewClient(request)
                : buildErrorResponse(errors);
    }

    private AddClientResponse buildErrorResponse(List<CoreError> errors) {
        return new AddClientResponse(errors);
    }

    private AddClientResponse addNewClient(AddClientRequest request) {
        Client client = new Client(
                request.getFirstName(),
                request.getLastName(),
                request.getPersonalCode(),
                request.getClientAgeGroup(),
                request.getWorkout());
        database.addClient(client);
        return new AddClientResponse(client);
    }

}
