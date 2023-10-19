package fitness_club.services;

import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.services.AddClientService;
import fitness_club.services.ChangeClientWorkoutService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ChangeClientWorkoutServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private ChangeClientWorkoutService changeClientWorkout;


    @Test
    void changeClientWorkout() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase);
        changeClientWorkout = new ChangeClientWorkoutService(inMemoryDatabase);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        addClient.addClient("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        changeClientWorkout.changeClientWorkout("12-12", Workouts.SWIMMING_POOL);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}