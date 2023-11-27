package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientOrderValidator;
import lv.avangardteen.core.data.Database;
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

class ClientServiceMockitaTest {
    @Mock
    private ClientOrderValidator validator;
    @Mock
    private Database database;
    @Mock
    private CalculateDimensionsWheelchair calculateDimensionsWheelchair;
    @InjectMocks
    private ClientService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void ClientServiceWithError() {
        ClientRequest notValidationRequest = new ClientRequest(
                "Name", 12345, "Riga",
                11, 22, 33, 11,
                17, 31, 21, 41);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(List.of(
                new CoreError("Client service", "Incorrect Clients request data!")));
        //    service = new ClientService(database,validator);
        ClientResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());

    }

    @Test
    public void ClientServiceWithoutError() {
        ClientRequest request = new ClientRequest(
                "Name", 12345, "Riga",
                11, 22, 33, 11,
                17, 31, 21, 41);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        ClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).addUser(any());

    }

}