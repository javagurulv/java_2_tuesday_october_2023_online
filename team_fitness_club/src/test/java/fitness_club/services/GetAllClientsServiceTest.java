package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.requests.AddClientRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetAllClientsServiceTest {
    private GetAllClientsService getAllClients;
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;

    @Test
    void getAllClientsFromDb() {
        inMemoryDatabase =  new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        AddClientRequest addFirstClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        AddClientRequest addSecondClientRequest = new AddClientRequest("Ccc", "Ddd", "12-13", ClientAgeGroups.SENIOR, Workouts.GYM);
        addClient.execute(addFirstClientRequest);
        addClient.execute(addSecondClientRequest);
        Client client1 = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        Client client2 = new Client("Ccc", "Ddd", "12-13", ClientAgeGroups.SENIOR, Workouts.GYM);
        getAllClients = new GetAllClientsService(inMemoryDatabase);
        assertEquals(getAllClients.getAllClients().size(), 2);
        assertTrue(getAllClients.getAllClients().contains(client1));
        assertTrue(getAllClients.getAllClients().contains(client2));



    }

    @Test
    void getAllClientsShouldNotBeNull() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        AddClientRequest addFirstClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        AddClientRequest addSecondClientRequest = new AddClientRequest("Ccc", "Ddd", "12-13", ClientAgeGroups.SENIOR, Workouts.GYM);
        addClient.execute(addFirstClientRequest);
        addClient.execute(addSecondClientRequest);
        getAllClients = new GetAllClientsService(inMemoryDatabase);
        assertFalse(getAllClients.getAllClients().isEmpty());

    }
}