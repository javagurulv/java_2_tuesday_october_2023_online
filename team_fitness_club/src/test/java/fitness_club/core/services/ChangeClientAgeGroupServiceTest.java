package fitness_club.core.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.ChangeClientAgeGroupService;
import fitness_club.data_vlidation.ChangeClientAgeGroupValidator;
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
        changeClientAgeGroupService = new ChangeClientAgeGroupService(inMemoryDatabase, new ChangeClientAgeGroupValidator());
        AddClientRequest addClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        addClient.execute(addClientRequest);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        ChangeClientAgeGroupRequest changeClientAgeGroupRequest = new ChangeClientAgeGroupRequest("12-12", ClientAgeGroups.SENIOR);
        changeClientAgeGroupService.execute(changeClientAgeGroupRequest);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));
    }
}