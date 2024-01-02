package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.requests.FindUniqueClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.FindUniqueClientResponse;
import fitness_club.core.services.vlidators.client.FindUniqueClientRequestValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindUniqueClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @Mock
    private FindUniqueClientRequestValidator validator;

    @InjectMocks
    private FindUniqueClientService service;

    @Test
    public void shouldFindClientWithPersonaCodeFromDatabase() {
        FindUniqueClientRequest request = new FindUniqueClientRequest("12-12");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(clientRepository.findUniqueClient("12-12")).thenReturn(true);
        FindUniqueClientResponse response = service.execute(request);
        Assert.assertFalse(response.hasErrors());
        Assert.assertTrue(response.isClientFound());
    }
    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        FindUniqueClientRequest notValidRequest = new FindUniqueClientRequest(null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode",
                "Field personal code must not be empty!")));
        FindUniqueClientResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFails() {
        FindUniqueClientRequest notValidRequest = new FindUniqueClientRequest(null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode",
                "Field personal code must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(clientRepository);
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidator() {
        FindUniqueClientRequest notValidRequest = new FindUniqueClientRequest(null);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("personalCode",
                "Field personal code must not be empty!")));
        FindUniqueClientResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Field personal code must not be empty!");
    }

}