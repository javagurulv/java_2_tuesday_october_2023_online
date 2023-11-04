package fitness_club.services;

import fitness_club.core.database.Database;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.services.GetAllClientsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(MockitoJUnitRunner.class)
public class GetAllClientsServiceTest {
   /* @Mock
    private Database database;
    @InjectMocks
    private GetAllClientsService service;

    @Test
    public void shouldGetClientsFromDb() {
        database = new FakeDatabase();
        List<Client> clients = List.of(new Client("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM));
        Mockito.when(database.getAllClients()).thenReturn(clients);
        GetAllClientsRequest request = new GetAllClientsRequest();
        GetAllClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getPersonalCode(), "12-12");
    }

    */
}

class FakeDatabase implements Database {

    @Override
    public void addClient(Client client) {

    }

    @Override
    public boolean deleteClientByPersonalCode(String personalCode) {
        return false;
    }

    @Override
    public List<Client> getAllClients() {
        return List.of(new Client("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM));
    }

    @Override
    public void saveClient(List<Client> clients) {

    }

    @Override
    public List<Client> findByFirstName(String firsName) {
        return null;
    }

    @Override
    public List<Client> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }
}
    /*@Test
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

     */
