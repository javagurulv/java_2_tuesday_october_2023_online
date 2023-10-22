package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.services.AddClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AddClientServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;

    @Test
    void addClient() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        AddClientRequest request = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        addClient.execute(request);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        Assertions.assertTrue(inMemoryDatabase.getAllClients().contains(client));

    }
}



//class AddClientServiceTest {
//      private AddClientService addClient;
//
//
//    @Test
//    void addClient() {
//        inMemoryDatabase =  new InMemoryDatabase();
//        addClient = new AddClientService(inMemoryDatabase);
//        Client client = new Client("Aaa", "Bbb", "12-12",ClientAgeGroups.SENIOR, Workouts.GYM);
//        addClient.execute("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
//        Assertions.assertTrue(inMemoryDatabase.getAllClients().contains(client));
//
//
//    }
//}