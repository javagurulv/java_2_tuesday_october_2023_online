package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.data_vlidation.DeleteClientRequestValidator;
import fitness_club.database.InMemoryDatabase;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.requests.AddClientRequest;
import fitness_club.requests.DeleteClientRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteClientServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private DeleteClientService deleteClient;

    @Test
    void removeClient() {
        inMemoryDatabase =  new InMemoryDatabase();
        deleteClient = new DeleteClientService(inMemoryDatabase, new DeleteClientRequestValidator());
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        AddClientRequest addFirstClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        AddClientRequest addSecondClientRequest = new AddClientRequest("Ccc", "Ddd", "12-13", ClientAgeGroups.SENIOR, Workouts.GYM);
        DeleteClientRequest deleteSecondClientRequest = new DeleteClientRequest("12-13");
        addClient.execute(addFirstClientRequest);
        addClient.execute(addSecondClientRequest);
        Client client = new Client("Ccc", "Ddd", "12-13",ClientAgeGroups.SENIOR, Workouts.GYM);
        deleteClient.execute(deleteSecondClientRequest);
        Assertions.assertFalse(inMemoryDatabase.getAllClients().contains(client));
        Assertions.assertEquals(inMemoryDatabase.getAllClients().size(),1);
    }
}