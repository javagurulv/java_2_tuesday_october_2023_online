package lv.avangardteen.core.service;
/*

import lv.avangardteen.core.database.UserSizeDb;
import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.OrderResponse;
import lv.avangardteen.core.service.validate.OrderValidator;
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
    private OrderValidator validator;
    @Mock
    private UserSizeDb userSizeDB;
    @Mock
    private WheelchairDB wheelchairDB;
    @Mock
    private CalculateDimensionsWheelchair calculateDimensionsWheelchair;
    @InjectMocks
    private OrderService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ClientServiceWithError() {
        OrderRequest notValidationRequest = new OrderRequest(
                22, 22, 22, 22);

        Mockito.when(validator.validate(notValidationRequest.getUserSizes())).thenReturn(List.of(
                new CoreError("Client service", "Incorrect Clients request data!")));

        OrderResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());

    }

    @Test
    public void ClientServiceWithoutError() {
        OrderRequest request = new OrderRequest(
                22, 22, 22, 22);
        Mockito.when(validator.validate(request.getUserSizes())).thenReturn(List.of());
        OrderResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(userSizeDB).addUserSize(any());
        verify(wheelchairDB).addWheelchair(any());
    }
}

*/
