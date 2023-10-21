package fitness_club.services;
import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.DeleteClientRequestValidator;
import fitness_club.database.Database;
import fitness_club.requests.DeleteClientRequest;
import fitness_club.responses.DeleteClientResponse;

import java.util.ArrayList;
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

        List<CoreError> errors = new ArrayList<>();
        if (request.getPersonalCode() == null || request.getPersonalCode().isBlank()) {
            errors.add(new CoreError("Personal Code", "Must not be empty!"));
        }

        if (!errors.isEmpty()) {
            return new DeleteClientResponse(errors);
        } else {
            database.removeClient(request.getPersonalCode());
            return new DeleteClientResponse();
        }
    }
}

