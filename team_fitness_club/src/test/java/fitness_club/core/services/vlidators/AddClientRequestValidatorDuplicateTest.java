package fitness_club.core.services.vlidators;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.client.AddClientRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.chrono.JapaneseChronology;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class AddClientRequestValidatorDuplicateTest {
    @Mock
    private JpaClientRepository clientRepository;
    @InjectMocks
    private AddClientRequestValidator validator;

    @Test
    public void shouldReturnErrorWhenDuplicateFound() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12");
        clientRepository = Mockito.mock(JpaClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        Client client = new Client("Andrey", "Pupkin",
                "12-12");
        Mockito.when(clientRepository.findByPersonalCodeLike("12-12")).thenReturn(List.of(client));
        List<CoreError> errors = validator.validate(request);
        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getField(), "uniqueClient");
        assertEquals(errors.get(0).getMessage(), "Is duplicate! Client with such personal code is already in database!");
    }

    @Test
    public void shouldNotReturnErrorWhenDuplicateNotFound() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12");
        clientRepository = Mockito.mock(JpaClientRepository.class);
        validator = new AddClientRequestValidator(clientRepository);
        Mockito.when(clientRepository.findByPersonalCodeLike("12-12")).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}