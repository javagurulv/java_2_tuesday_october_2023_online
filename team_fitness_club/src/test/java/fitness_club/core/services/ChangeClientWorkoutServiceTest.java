package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientWorkoutsResponse;
import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.ChangeClientWorkoutService;
import fitness_club.data_vlidation.ChangeClientWorkoutsValidator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ChangeClientWorkoutServiceTest {
    @Mock
    private Database database;
    @Mock
    private ChangeClientWorkoutsValidator validator;
   @InjectMocks
    private ChangeClientWorkoutService service;

    @Test
    void shouldChangeClientWorkoutByPersonalCodeToNew() {
        ChangeClientWorkoutsRequest request= new ChangeClientWorkoutsRequest("1-2",Workouts.GYM);
        validator =mock(ChangeClientWorkoutsValidator.class);
        when(validator.validate(request)).thenReturn(List.of());
        database=mock(Database.class);
        when(database.clientWorkoutsChangedByPersonalCode("1-2",Workouts.GYM)).thenReturn(true);
        service= new ChangeClientWorkoutService(database,validator);
        ChangeClientWorkoutsResponse response = service.execute(request);
        Assert.assertTrue(!response.hasErrors());
        Assert.assertTrue(response.isClientWorkoutsChanged());
    }


}