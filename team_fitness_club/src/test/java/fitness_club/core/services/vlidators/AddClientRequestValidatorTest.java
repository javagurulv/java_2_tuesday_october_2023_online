package fitness_club.core.services.vlidators;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.ClientRepositoryImpl;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.AddClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddClientRequestValidatorTest {
    @Mock
    private ClientRepositoryImpl clientRepositoryImpl;
    @Mock
    private AddClientService service;
    @InjectMocks
    private AddClientRequestValidator validator;

    @Test
    public void shouldReturnErrorWhenFirstNameIsNull() {
        service = new AddClientService(clientRepositoryImpl, validator);
        AddClientRequest request = new AddClientRequest(null, "lastName", "personalCode");
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenFirstNameIsEmpty() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsNull() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", null, "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsEmpty() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", "", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenClientFirstNameIsNumbers() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("5", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenClientFirstNameIsSymbol() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("!", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenClientLastNameIsNumbers() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", "5", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenClientLastNameIsSymbol() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", "!", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPersonaCodeNull() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", null);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personalCode");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPersonaCodeIsEmpty() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", "");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personalCode");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorWhenAllFieldsArePresent() {
        clientRepositoryImpl = Mockito.mock(ClientRepositoryImpl.class);
        validator = new AddClientRequestValidator(clientRepositoryImpl);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertTrue(errors.isEmpty());
    }
}
