package lv.avangardteen.core.service;

import lv.avangardteen.core.database.UserSizeDb;
import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.UserSizeRegistrationResponse;
import lv.avangardteen.core.service.validate.PersonalSizeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class UserSizeRegistrationServiceTest {
    @Mock
    private PersonalSizeValidator validator;
    @Mock
    private UserSizeDb userSizeDB;
    @Mock
    private WheelchairDB wheelchairDB;
    @Mock
    private CalculateDimensionsWheelchair calculateDimensionsWheelchair;
    @InjectMocks
    private UserSizeRegistrationService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ClientServiceWithError() {
        UserSizeRegistrationRequest notValidationRequest = new UserSizeRegistrationRequest(
                22, 22, 22, 22);

        Mockito.when(validator.validate(notValidationRequest.getUserSizes())).thenReturn(List.of(
                new CoreError("Client service", "Incorrect Clients request data!")));

        UserSizeRegistrationResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());

    }

    @Test
    public void ClientServiceWithoutError() {
        UserSizeRegistrationRequest request = new UserSizeRegistrationRequest(
                22, 22, 22, 22);
        Mockito.when(validator.validate(request.getUserSizes())).thenReturn(List.of());
        UserSizeRegistrationResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(userSizeDB).addUserSize(any());
        verify(wheelchairDB).addWheelchair(any());
    }
}

