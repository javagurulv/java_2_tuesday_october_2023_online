package services;

import database.InMemoryDatabase;
import domain.Client;
import domain.Workouts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddClientServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;

    @Test
    void addClient() {
        inMemoryDatabase =  new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase);
        Client client = new Client("Aaa", "Bbb", "12-12", Workouts.GYM);
        addClient.addClient("Aaa", "Bbb", "12-12", Workouts.GYM);
        Assertions.assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}