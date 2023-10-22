package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.DeleteClientRequest;
import fitness_club.core.responses.DeleteClientResponse;
import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.DeleteClientRequestValidator;

import java.util.List;

public class DeleteClientService {

    private Database database;
    private DeleteClientRequestValidator validator;

    public DeleteClientService(Database database,
                               DeleteClientRequestValidator validator) {
        this.validator = validator;
        this.database = database;
    }

    public DeleteClientResponse execute(DeleteClientRequest request) {

        List<CoreError> errors = validator.validate(request);

        return errors.isEmpty()
                ? deleteClientLogic(request)
                : buildErrorResponse(errors);
    }

    private DeleteClientResponse buildErrorResponse(List<CoreError> errors) {
        return new DeleteClientResponse(errors);
    }

    private DeleteClientResponse deleteClientLogic(DeleteClientRequest request) {
        database.removeClient(request.getPersonalCode());
        return new DeleteClientResponse();
    }
}

