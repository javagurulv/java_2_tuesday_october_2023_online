package services;
import database.*;
import domain.*;

import java.util.List;

public class ChangeClientWorkoutService {

    private Database database;

    public ChangeClientWorkoutService(Database database) {
        this.database = database;
    }

    public void changeClientWorkout(String firstName, String lastName, String personalCode, Workouts workout) {
        Client clientToChangeWorkout = new Client(firstName, lastName, personalCode);
        List<Client> clients = database.getAllClients();
        for (Client client: clients) {
            if (client.equals(clientToChangeWorkout)) {
                client.setWorkouts(workout);
                database.saveClient(clients);
                break;
            }
        }
    }
}
