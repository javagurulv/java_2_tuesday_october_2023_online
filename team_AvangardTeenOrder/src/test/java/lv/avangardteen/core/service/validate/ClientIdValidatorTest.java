package lv.avangardteen.core.service.validate;

import lv.avangardteen.dto.Client;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientIdValidatorTest {
    private Database database;
    private ClientIdValidator clientIdValidator;

    @Test
    public void idIsZero() {
        database = Mockito.mock(Database.class);
        clientIdValidator = new ClientIdValidator(database);
        List<CoreError> coreErrors = clientIdValidator.validate(0l);

        assertEquals(coreErrors, List.of(new CoreError("idClient", "Must not be empty!")));
    }

    @Test
    public void idIsNull() {
        database = Mockito.mock(Database.class);
        clientIdValidator = new ClientIdValidator(database);
        List<CoreError> coreErrors = clientIdValidator.validate(null);

        assertEquals(coreErrors, List.of(new CoreError("idClient", "Must not be empty!")));
    }

    @Test
    public void idIsAbsent() {
        database = Mockito.mock(Database.class);
        Mockito.when(database.getClient(5l)).thenReturn(null);
        clientIdValidator = new ClientIdValidator(database);
        List<CoreError> coreErrors = clientIdValidator.validate(5l);
        assertEquals(coreErrors, List.of(new CoreError("idClient", "Order with this id not found!")));
    }

    @Test
    public void withoutError() {
        database = Mockito.mock(Database.class);
        Mockito.when(database.getClient(5l)).thenReturn(new Client());
        clientIdValidator = new ClientIdValidator(database);
        List<CoreError> coreErrors = clientIdValidator.validate(5l);
        assertEquals(coreErrors, List.of());
    }

}