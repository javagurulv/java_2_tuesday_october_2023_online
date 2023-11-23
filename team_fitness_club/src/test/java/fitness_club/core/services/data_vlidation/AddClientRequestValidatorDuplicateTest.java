package fitness_club.core.services.data_vlidation;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.CoreError;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class AddClientRequestValidatorDuplicateTest {
    @Mock
    private Database database;
    @InjectMocks
    private AddClientRequestValidator validator;

    @Test
    void shouldReturnErrorWhenDuplicateFound() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        Client client = new Client("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        Mockito.when(database.findByPersonalCode("12-12")).thenReturn(List.of(client));
        List<CoreError> errors = validator.validate(request);
        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getField(), "uniqueClient");
        assertEquals(errors.get(0).getMessage(), "Field must not be duplicated! Client with such personal code is already in database!");
    }

    @Test
    void shouldNotReturnErrorWhenDuplicateNotFound() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        Mockito.when(database.findByPersonalCode("12-12")).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}