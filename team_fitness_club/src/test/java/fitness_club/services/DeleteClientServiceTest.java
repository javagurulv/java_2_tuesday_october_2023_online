package fitness_club.services;

import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.DeleteClientRequest;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.DeleteClientService;
import fitness_club.data_vlidation.DeleteClientRequestValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeleteClientServiceTest {
    private AddClientService addClient;
    private InMemoryDatabase inMemoryDatabase;
    private DeleteClientService deleteClient;

    @Test
    void removeClient() {
        inMemoryDatabase =  new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        deleteClient = new DeleteClientService(inMemoryDatabase, new DeleteClientRequestValidator());
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