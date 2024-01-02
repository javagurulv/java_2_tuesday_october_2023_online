package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.services.vlidators.workout.ChangeClientWorkoutsValidator;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ChangeClientWorkoutServiceTest {
    @Mock
    private ClientRepository clientRepository;
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