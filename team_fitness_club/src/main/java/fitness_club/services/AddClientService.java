package fitness_club.services;

import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;

public class AddClientService {

    private Database database;

    public AddClientService(Database database) {
        this.database = database;
    }

    public void addClient(String firstName,String lastName, String personalCode, ClientAgeGroups clientAgeGroup, Workouts workout) {
        Client client = new Client(firstName, lastName, personalCode, clientAgeGroup, workout);
        database.addClient(client);
    }
}
