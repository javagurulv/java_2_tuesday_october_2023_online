package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.requests.RemoveClientRequest;

import fitness_club.data_vlidation.RemoveClientRequestValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class RemoveClientServiceTest {
    @Mock
    private Database database;
    @Mock
    private RemoveClientRequestValidator validator;
    @InjectMocks
    private DeleteClientService service;
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldDeleteClientWithPersonaCodeFromDatabase() {
        RemoveClientRequest request = new RemoveClientRequest("12-12");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.deleteClientByPersonalCode("12-12")).thenReturn(true);
        RemoveClientResponse response = service.execute(request);
        Assert.assertFalse(response.hasErrors());
        Assert.assertTrue(response.isClientRemoved());
    }
}
   /* @Test
    void removeClient() {
        inMemoryDatabase =  new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        deleteClient = new DeleteClientService(inMemoryDatabase, new DeleteClientRequestValidator());
        AddClientRequest addFirstClientRequest = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM, FitnessCentre.AKROPOLE);
        AddClientRequest addSecondClientRequest = new AddClientRequest("Ccc", "Ddd", "12-13", ClientAgeGroups.SENIOR, Workouts.GYM, FitnessCentre.AKROPOLE);
        DeleteClientRequest deleteSecondClientRequest = new DeleteClientRequest("12-13");
        addClient.execute(addFirstClientRequest);
        addClient.execute(addSecondClientRequest);
        Client client = new Client("Ccc", "Ddd", "12-13",ClientAgeGroups.SENIOR, Workouts.GYM);
        deleteClient.execute(deleteSecondClientRequest);
        Assertions.assertFalse(inMemoryDatabase.getAllClients().contains(client));
        Assertions.assertEquals(inMemoryDatabase.getAllClients().size(),1);
    }

    */
