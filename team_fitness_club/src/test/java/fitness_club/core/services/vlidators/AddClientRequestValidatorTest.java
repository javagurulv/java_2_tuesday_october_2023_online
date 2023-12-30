package fitness_club.core.services.vlidators;

import fitness_club.core.database.ClientRepository;
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
    private ClientRepository clientRepository;
    @Mock
    private AddClientService service;
    @InjectMocks
    private AddClientRequestValidator validator;

    @Test
    public void shouldReturnErrorWhenFirstNameIsNull() {
        service = new AddClientService(clientRepository, validator);
        AddClientRequest request = new AddClientRequest(null, "lastName", "personalCode");
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenFirstNameIsEmpty() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsNull() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", null, "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsEmpty() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", "", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenClientFirstNameIsNumbers() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("5", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenClientFirstNameIsSymbol() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("!", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "firstName");
        assertEquals(errors.get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenClientLastNameIsNumbers() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", "5", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenClientLastNameIsSymbol() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", "!", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "lastName");
        assertEquals(errors.get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorWhenPersonaCodeNull() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", null);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personalCode");
        assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPersonaCodeIsEmpty() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", "");
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "personalCode");
        assertEquals(errors.get(0).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorWhenAllFieldsArePresent() {
        clientRepository = Mockito.mock(ClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        AddClientRequest request = new AddClientRequest("firstName", "lastName", "personalCode");
        List<CoreError> errors = validator.validate(request);
        assertTrue(errors.isEmpty());
    }
}
