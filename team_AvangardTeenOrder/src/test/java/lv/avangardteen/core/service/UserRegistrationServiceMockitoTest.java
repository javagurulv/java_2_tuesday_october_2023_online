package lv.avangardteen.core.service;


import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.validate.PersonalDateValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UserRegistrationServiceMockitoTest {
    @Mock
    private PersonalDateValidation validator;
    @Mock
    private Database database;

    @InjectMocks
    private UserRegistrationService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ClientServiceWithError() {
        UserRegistrationRequest notValidationRequest = new UserRegistrationRequest(
                "Name", 111l, 12345l, "Riga");

        Mockito.when(validator.validate(notValidationRequest.getUserRegistration())).thenReturn(List.of(
                new CoreError("Client service", "Incorrect Clients request data!")));

        UserRegistrationResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());

    }

    @Test
    public void ClientServiceWithoutError() {
        UserRegistrationRequest request = new UserRegistrationRequest(
                "Name", 111l, 12345l, "Riga");
        Mockito.when(validator.validate(request.getUserRegistration())).thenReturn(List.of());
        UserRegistrationResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).addUser(any());

    }

}
