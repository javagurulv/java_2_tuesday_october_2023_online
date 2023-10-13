package services;
import database.*;
import domain.*;

public class ChangeClientWorkoutService {

    private Database database;

    public ChangeClientWorkoutService(Database database) {
        this.database = database;
    }

    public void changeClientWorkout(String firstName, String lastName, String personalCode, Workouts workout) {
        Client clientToChangeWorkout = new Client(firstName, lastName, personalCode);
        for (Client client: database.getAllClients()) {
            if (client.equals(clientToChangeWorkout)) {
                client.setWorkouts(workout);
            }
        }
    }
}
