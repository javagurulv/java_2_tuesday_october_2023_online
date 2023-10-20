package fitness_club.services;

import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ChangeClientAgeGroupServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private ChangeClientAgeGroupService changeClientAgeGroupService;


    @Test
    void changeClientAgeGroupTest() {
        /*inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase);
        changeClientAgeGroupService = new ChangeClientAgeGroupService(inMemoryDatabase);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.SWIMMING_POOL);
        addClient.("Aaa", "Bbb", "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        changeClientAgeGroupService.changeClientAgeGroup("12-12", ClientAgeGroups.SENIOR);
        assertTrue(inMemoryDatabase.getAllClients().contains(client));

         */
    }
}