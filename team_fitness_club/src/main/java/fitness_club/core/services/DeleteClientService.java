package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.RemoveClientRequestValidator;

import java.util.List;

public class DeleteClientService {

    private Database database;
    private RemoveClientRequestValidator validator;

    public DeleteClientService(Database database,
                               RemoveClientRequestValidator validator) {
        this.validator = validator;
        this.database = database;
    }

    public RemoveClientResponse execute(RemoveClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientResponse(errors);
        }
        boolean isClientRemoved = database.deleteClientByPersonalCode(request.getPersonalCode());
        return new RemoveClientResponse(isClientRemoved);
    }
}

