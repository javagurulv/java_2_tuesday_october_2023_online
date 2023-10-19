package fitness_club.core.services;
import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;

public class DeleteClientService {

    private Database database;

    public DeleteClientService(Database database) {
        this.database = database;
    }

    public void removeClient(String firstName, String lastName, String personalCode) {
        Client client = new Client(firstName, lastName, personalCode);
        database.removeClient(client);
    }
}

