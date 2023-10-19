package fitness_club.services;
import fitness_club.database.Database;

public class DeleteClientService {

    private Database database;

    public DeleteClientService(Database database) {
        this.database = database;
    }

    public void removeClient(String personalCode) {
              database.removeClient(personalCode);
    }
}

