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
    void shouldChangeClientAgeGroupByPersonalCodeToNew() {
        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest("1-2", ClientAgeGroups.ADULT);
        validator = mock(ChangeClientAgeGroupValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        database = mock(Database.class);
        Mockito.when(database.clientAgeGroupChangedByPersonalCode("1-2", ClientAgeGroups.ADULT)).thenReturn(true);
        service = new ChangeClientAgeGroupService(database, validator);
        ChangeClientAgeGroupResponse response = service.execute(request);
        Assert.assertTrue(!response.hasErrors());
        Assert.assertTrue(response.isClientAgeGroupChanged());
    }
}
