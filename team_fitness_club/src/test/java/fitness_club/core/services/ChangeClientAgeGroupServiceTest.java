package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.services.data_vlidation.ChangeClientAgeGroupValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class ChangeClientAgeGroupServiceTest {
    @Mock
    private Database database;

    @Mock
    private ChangeClientAgeGroupValidator validator;
    @InjectMocks
    private ChangeClientAgeGroupService service;


    @Test
    public void shouldChangeClientAgeGroupByPersonalCodeToNew() {
        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest("1-2", ClientAgeGroups.ADULT);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.clientAgeGroupChangedByPersonalCode("1-2", ClientAgeGroups.ADULT)).thenReturn(true);
        ChangeClientAgeGroupResponse response = service.execute(request);
        Assert.assertTrue(!response.hasErrors());
        Assert.assertTrue(response.isClientAgeGroupChanged());
    }
}
