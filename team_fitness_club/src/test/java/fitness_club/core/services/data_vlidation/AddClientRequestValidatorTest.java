package fitness_club.core.services.data_vlidation;

import fitness_club.core.database.Database;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.services.AddClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddClientRequestValidatorTest {
    @Mock
    private Database database;
    @Mock
    private AddClientService service;
    @InjectMocks
    private AddClientRequestValidator validator;

    @Test
    void shouldReturnErrorWhenFirstNameIsNull() {
        service = new AddClientService(database, validator);
        AddClientRequest request = new AddClientRequest(null, "lastName", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenFirstNameIsEmpty() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("", "lastName", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenLastNameIsNull() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", null, "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenLastNameIsEmpty() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", "", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenClientFirstNameIsNumbers() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("5", "lastName", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenClientFirstNameIsSymbol() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("!", "lastName", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenClientLastNameIsNumbers() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", "5", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenClientLastNameIsSymbol() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", "!", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    void shouldReturnErrorWhenPersonaCodeNull() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", null,
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personalCode");
        assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    void shouldReturnErrorWhenPersonaCodeIsEmpty() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", "",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personalCode");
        assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    void shouldNotReturnErrorWhenAllFieldsArePresent() {
        database = Mockito.mock(Database.class);
        validator = new AddClientRequestValidator(database);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", "personalCode",
                ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
        assertTrue(errors.isEmpty());
    }
}
