package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.requests.AddClientRequest;
import fitness_club.requests.ChangeClientWorkoutsRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ChangeClientWorkoutServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private ChangeClientWorkoutService changeClientWorkout;


    @Test
    void changeClientWorkout() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        changeClientWorkout = new ChangeClientWorkoutService(inMemoryDatabase);
        AddClientRequest addClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        addClient.execute(addClientRequest);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        ChangeClientWorkoutsRequest changeClientWorkoutsRequest = new ChangeClientWorkoutsRequest("12-12", Workouts.GYM);
        changeClientWorkout.execute(changeClientWorkoutsRequest);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}