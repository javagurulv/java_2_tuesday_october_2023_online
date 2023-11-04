package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.services.AddClientService;
import fitness_club.data_vlidation.CoreError;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddClientServiceTest {

    @Mock
    private AddClientRequestValidator validator;
    @Mock
    private Database database;
    @InjectMocks
    private AddClientService service;

    @Test
    void addClientShouldSuccess_Mockito_style() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        validator = mock(AddClientRequestValidator.class);
        when(validator.validate(request)).thenReturn(List.of());
        database = mock(Database.class);
        service = new AddClientService(database, validator);
        AddClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).addClient(any());
    }

    @Test
    void addClientShouldFail_Mockito_style() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM);
        validator = mock(AddClientRequestValidator.class);
        when(validator.validate(request)).thenReturn(List.of(new CoreError("error", "Warning")));
        service = new AddClientService(null, validator);
        AddClientResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        Assert.assertEquals(response.getErrors().size(), 1);
    }
}

   /* @Test
    void addClient() {
        inMemoryDatabase = new InMemoryDatabase();
        addClient = new AddClientService(inMemoryDatabase, new AddClientRequestValidator());
        AddClientRequest request = new AddClientRequest("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        addClient.execute(request);
        Client client = new Client("Aaa", "Bbb", "12-12", ClientAgeGroups.SENIOR, Workouts.GYM);
        Assertions.assertTrue(inMemoryDatabase.getAllClients().contains(client));

    }

    */


