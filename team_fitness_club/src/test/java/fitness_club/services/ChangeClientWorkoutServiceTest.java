package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.ChangeClientWorkoutService;
import fitness_club.data_vlidation.ChangeClientWorkoutsValidator;
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
        changeClientWorkout = new ChangeClientWorkoutService(inMemoryDatabase, new ChangeClientWorkoutsValidator());
        AddClientRequest addClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        addClient.execute(addClientRequest);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        ChangeClientWorkoutsRequest changeClientWorkoutsRequest = new ChangeClientWorkoutsRequest("12-12", Workouts.GYM);
        changeClientWorkout.execute(changeClientWorkoutsRequest);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}