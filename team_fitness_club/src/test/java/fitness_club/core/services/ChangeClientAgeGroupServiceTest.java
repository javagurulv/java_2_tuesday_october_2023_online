package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.data_vlidation.ChangeClientAgeGroupValidator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ChangeClientAgeGroupServiceTest {
    @Mock
    private Database database;

    @Mock
    private ChangeClientAgeGroupValidator validator;
    @InjectMocks
    private ChangeClientAgeGroupService service;

    @Test
    void shouldChangeClientAgeGroupByPersonalCodeTest() {
        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest("1-2", ClientAgeGroups.ADULT);
        validator = mock(ChangeClientAgeGroupValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        database = mock(Database.class);
        Mockito.when(database.clientAgeGroupChangedByPersonalCode("1-2", ClientAgeGroups.ADULT)).thenReturn(true);
        service = new ChangeClientAgeGroupService(database, validator);
        ChangeClientAgeGroupResponse response = service.execute(request);
        Assert.assertFalse(response.hasErrors());
        Assert.assertTrue(response.isClientAgeGroupChanged());
    }


   /* @Test
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

    */
}