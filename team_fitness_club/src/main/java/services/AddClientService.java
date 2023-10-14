package services;
import database.*;
import domain.*;

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
