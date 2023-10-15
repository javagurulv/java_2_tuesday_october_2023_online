package services;

import database.InMemoryDatabase;
import domain.Client;
import domain.Workouts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteClientServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private  DeleteClientService deleteClient;

    @Test
    void removeClient() {
        inMemoryDatabase =  new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase);
        deleteClient = new DeleteClientService(inMemoryDatabase);
        Client client = new Client("Aaa", "Bbb", "12-12", Workouts.GYM);
        addClient.addClient("Aaa", "Bbb", "12-12", Workouts.GYM);
        addClient.addClient("Ccc", "Ddd", "12-13", Workouts.SWIMMING_POOL);
        deleteClient.removeClient("Aaa", "Bbb", "12-12");
        Assertions.assertFalse(inMemoryDatabase.getAllClients().contains(client));
        Assertions.assertEquals(inMemoryDatabase.getAllClients().size(),1);
    }
}