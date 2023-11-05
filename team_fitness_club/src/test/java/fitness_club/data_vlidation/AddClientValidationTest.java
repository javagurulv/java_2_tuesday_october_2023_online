package fitness_club.data_vlidation;

import fitness_club.core.database.Database;
import fitness_club.core.database.InFileDatabase;
import fitness_club.core.database.InMemoryDatabase;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class AddClientValidationTest {
    @Mock
    private Database database = new InFileDatabase();
    @Mock
    private ClientAgeGroups clientAgeGroup;
    @Mock
    private Workouts workout;
    @InjectMocks
    private AddClientRequestValidator validator = new AddClientRequestValidator(database);

    @Test
    void shouldReturnErrorWhenClientFirstNameIsNull() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn(null);
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "firstName");
            assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientFirstNameIsEmpty() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("");
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "firstName");
            assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientLastNameIsNull() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn(null);
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "lastName");
            assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientLastNameIsEmpty() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn("");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "lastName");
            assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientPersonalCodeIsNull() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn(null);
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientPersonaCodeIsEmpty() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn("");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "personalCode");
            assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientFirstNameIsNumbers() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("6");
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "firstName");
            assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientFirstNameIsSymbol() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("!");
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "firstName");
            assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientLastNameIsNumbers() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn("777");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "lastName");
            assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldReturnErrorWhenClientLastNameIsSymbol() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn(",");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "lastName");
            assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
        }
    }

    @Test
    void shouldNotReturnErrorWhenAllFieldsArePresent() {
        AddClientRequest request = mock(AddClientRequest.class);
        {
            when(request.getFirstName()).thenReturn("firstName");
            when(request.getLastName()).thenReturn("lastName");
            when(request.getPersonalCode()).thenReturn("personalCode");
            when(request.getClientAgeGroup()).thenReturn(clientAgeGroup);
            when(request.getWorkout()).thenReturn(workout);
            List<CoreError> errors = validator.validate(request);
            assertTrue(errors.isEmpty());
        }
    }
}
