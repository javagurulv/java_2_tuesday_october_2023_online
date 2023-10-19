package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.requests.DeleteClientRequest;
import fitness_club.responses.CoreError;
import fitness_club.responses.DeleteClientResponse;

import java.util.ArrayList;
import java.util.List;

public class DeleteClientService {

    private Database database;

    public DeleteClientService(Database database) {
        this.database = database;
    }

    public DeleteClientResponse execute(DeleteClientRequest request) {

        List<CoreError> errors = new ArrayList<>();
        if (request.getClientPersonalCodeToDelete() == null || request.getClientPersonalCodeToDelete().isBlank()) {
            errors.add(new CoreError("Personal Code", "Must not be empty!"));
        }

        if (!errors.isEmpty()) {
            return new DeleteClientResponse(errors);
        } else {
            database.removeClient(request.getClientPersonalCodeToDelete());
            return new DeleteClientResponse();
        }
    }
}

