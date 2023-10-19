package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.requests.DeleteClientRequest;
import fitness_club.responses.DeleteClientResponse;

public class DeleteClientService {

    private Database database;

    public DeleteClientService(Database database) {
        this.database = database;
    }

    public DeleteClientResponse execute(DeleteClientRequest request) {
        database.removeClient(request.getClientPersonalCodeToDelete());
        return new DeleteClientResponse(true);
    }
}

