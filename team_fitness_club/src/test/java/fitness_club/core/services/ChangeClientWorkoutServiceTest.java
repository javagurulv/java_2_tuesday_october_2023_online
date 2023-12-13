package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.responses.ChangeClientWorkoutsResponse;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.services.data_vlidation.ChangeClientWorkoutsValidator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.mockito.Mockito.when;
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ChangeClientWorkoutServiceTest {
    @Mock
    private Database database;
    @Mock
    private ChangeClientWorkoutsValidator validator;
   @InjectMocks
    private ChangeClientWorkoutService service;


   /* @Test
    public void shouldChangeClientWorkoutByPersonalCodeToNew() {
        ChangeClientWorkoutsRequest request= new ChangeClientWorkoutsRequest("1-2",Workouts.GYM);
        when(validator.validate(request)).thenReturn(List.of());
        when(database.clientWorkoutsChangedByPersonalCode("1-2",Workouts.GYM)).thenReturn(true);
        ChangeClientWorkoutsResponse response = service.execute(request);
        Assert.assertTrue(!response.hasErrors());
        Assert.assertTrue(response.isClientWorkoutsChanged());
    }

    */


}