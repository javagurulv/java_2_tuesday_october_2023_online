package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.requests.AddClientRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ChangeClientAgeGroupServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private ChangeClientAgeGroupService changeClientAgeGroupService;


    @Test
    void changeClientAgeGroupTest() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        changeClientAgeGroupService = new ChangeClientAgeGroupService(inMemoryDatabase);
        AddClientRequest addClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        addClient.execute(addClientRequest);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        changeClientAgeGroupService.changeClientAgeGroup("12-12", ClientAgeGroups.SENIOR);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}