package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.Workouts;

public class AddClientService {

    private Database database;

    public  AddClientService(Database database) {
        this.database = database;
    }

    public void addClient(String firstName, String lastName, String personalCode, Workouts workout) {
        Client client = new Client(firstName, lastName, personalCode, workout);
        database.addClient(client);
    }
}
