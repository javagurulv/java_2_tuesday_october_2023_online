package services;

import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.Workouts;
import fitness_club.services.AddClientService;
import fitness_club.services.DeleteClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteClientServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private DeleteClientService deleteClient;

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