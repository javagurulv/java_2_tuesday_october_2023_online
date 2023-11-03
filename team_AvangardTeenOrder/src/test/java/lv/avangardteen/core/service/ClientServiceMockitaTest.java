package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class ClientServiceMockitaTest {
    private ClientService service;
    private Database database;
    private ClientOrderValidator validator;

    @Test
    public void ClientServiceWithError(){
        ClientRequest notValidationRequest = new ClientRequest(
                "Name", 12345, "Riga",
                11,22,33, 11,
                17,31,21,41);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ClientOrderValidator.class);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(List.of(
                new CoreError("Client service", "Incorrect Clients request data!")));
        service = new ClientService(database,validator);
        ClientResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());

    }

    @Test
    public void ClientServiceWithoutError(){
        ClientRequest request = new ClientRequest(
                "Name", 12345, "Riga",
                11,22,33, 11,
                17,31,21,41);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ClientOrderValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        service = new ClientService(database,validator);
        ClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(database).addUser(any());

    }

}