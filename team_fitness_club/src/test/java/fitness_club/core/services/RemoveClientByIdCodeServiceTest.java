package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.requests.RemoveClientByIdRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.RemoveClientByIdResponse;
import fitness_club.core.services.validators.client.RemoveClientByIdRequestValidator;
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
public class RemoveClientByIdCodeServiceTest {
    @Mock
    private JpaClientRepository clientRepository;
    @Mock
    private RemoveClientByIdRequestValidator validator;
    @InjectMocks
    private RemoveClientByIdService service;

    @Test
    public void shouldReturnErrorWhenClientIdNotProvided() {
        RemoveClientByIdRequest request = new RemoveClientByIdRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("clientId", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveClientByIdResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "clientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteClientWithIdFromDb() {
                  Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        RemoveClientByIdRequest request = new RemoveClientByIdRequest(1L);
        RemoveClientByIdResponse response = service.execute(request);
            assertFalse(response.hasErrors());
            assertTrue(response.isClientRemoved());
        }
}
