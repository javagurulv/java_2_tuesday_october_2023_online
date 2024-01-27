package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RemoveClientRequestValidator;
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
public class RemoveClientServiceTest {

    @Mock private JpaClientRepository clientRepository;
    @Mock private RemoveClientRequestValidator validator;
    @InjectMocks private RemoveClientService service;

    @Test
    public void shouldReturnErrorWhenClientIdNotProvided() {
        RemoveClientRequest request = new RemoveClientRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("clientId", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveClientResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "clientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteClientWithIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        RemoveClientRequest request = new RemoveClientRequest(1L);
        RemoveClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isClientRemoved());
    }

}