package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.RemoveClientByPersonalCodeResponse;
import fitness_club.core.services.validators.client.RemoveClientByPersonalCodeRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class RemoveClientByPersonalCodeServiceTest {
    @Mock
    private JpaClientRepository clientRepository;
    @Mock
    private RemoveClientByPersonalCodeRequestValidator validator;
    @InjectMocks
    private RemoveClientByPersonalCodeService service;

    @Test
    public void shouldReturnErrorWhenClientPersonalCodeNotProvided() {
        RemoveClientByPersonalCodeRequest request = new RemoveClientByPersonalCodeRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("personalCode", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveClientByPersonalCodeResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteClientWithPersonalCodeFromDb() {
        RemoveClientByPersonalCodeRequest request = new RemoveClientByPersonalCodeRequest("12-12");
        RemoveClientByPersonalCodeResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isClientRemoved());
    }
}
