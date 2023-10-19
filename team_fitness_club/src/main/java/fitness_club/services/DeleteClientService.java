package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.domain.Client;

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

