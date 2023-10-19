package fitness_club.services;

import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.services.AddClientService;
import fitness_club.services.GetAllClientsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAllClientsServiceTest {
    private GetAllClientsService getAllClients;
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;

    @Test
    void getAllClientsFromDb() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase);
        Client client1 = new Client("Aaa", "Bbb", "12-12",ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        Client client2 = new Client("Ccc", "Ddd", "12-13",ClientAgeGroups.ADULT, Workouts.GYM);
        addClient.addClient("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        addClient.addClient("Ccc", "Ddd", "12-13", ClientAgeGroups.ADULT, Workouts.GYM);
        getAllClients = new GetAllClientsService(inMemoryDatabase);
        assertEquals(getAllClients.getAllClients().size(), 2);
        assertTrue(getAllClients.getAllClients().contains(client1));
        assertTrue(getAllClients.getAllClients().contains(client2));
    }

    @Test
    void getAllClientsShouldNotBeNull() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase);
        addClient.addClient("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        addClient.addClient("Ccc", "Ddd", "12-13",ClientAgeGroups.ADULT, Workouts.GYM);
        getAllClients = new GetAllClientsService(inMemoryDatabase);
        assertFalse(getAllClients.getAllClients().isEmpty());
    }
}