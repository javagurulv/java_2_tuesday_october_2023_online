package services;

import database.InMemoryDatabase;
import domain.Client;
import domain.Workouts;
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
        Client client = new Client("Aaa", "Bbb", "12-12", Workouts.SWIMMING_POOL);
        addClient.addClient("Aaa", "Bbb", "12-12", Workouts.GYM);
        changeClientWorkout.changeClientWorkout("Aaa", "Bbb", "12-12", Workouts.SWIMMING_POOL);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}