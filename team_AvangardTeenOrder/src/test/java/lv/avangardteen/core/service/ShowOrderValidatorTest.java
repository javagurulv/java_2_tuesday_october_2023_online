package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowOrderValidatorTest {
    private ClientIdValidator idValidator;
    private ShowOrderValidator validator;

    @Test
    public void clientIsAbsent() {
        Database database = Mockito.mock(Database.class);
        idValidator = new ClientIdValidator(database);
        ShowOrderRequest request = new ShowOrderRequest(5l);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        validator = new ShowOrderValidator(idValidator);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of(new CoreError("idClient", "Order with this id not found!")));

    }

    @Test
    public void clientIsFound() {
        Database database = Mockito.mock(Database.class);
        idValidator = new ClientIdValidator(database);
        ShowOrderRequest request = new ShowOrderRequest(5l);
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        validator = new ShowOrderValidator(idValidator);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList, List.of());

    }
}