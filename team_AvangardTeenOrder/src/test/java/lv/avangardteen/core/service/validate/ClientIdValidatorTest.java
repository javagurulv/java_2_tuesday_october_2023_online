package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.database.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class ClientIdValidatorTest {
    @Mock
    private Database database;
    @InjectMocks
    private OrderIdValidator orderIdValidator;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void idIsZero() {
        database = Mockito.mock(Database.class);
        orderIdValidator = new OrderIdValidator();
        List<CoreError> coreErrors = orderIdValidator.validate(0l);
        assertEquals(coreErrors, List.of(new CoreError("idClient", "Must not be empty!")));
    }

    @Test
    public void idIsNull() {
        database = Mockito.mock(Database.class);
        orderIdValidator = new OrderIdValidator();
        List<CoreError> coreErrors = orderIdValidator.validate(null);
        assertEquals(coreErrors, List.of(new CoreError("idClient", "Must not be empty!")));
    }

    @Test
    public void idIsAbsent() {
        when(database.getClientByOrderId(5l)).thenReturn(null);
        List<CoreError> errors = List.of(new CoreError("idClient", "Order with this id not found!"));
        List<CoreError> coreErrors = orderIdValidator.validate(5l);

        assertEquals(coreErrors, errors);
    }

    @Test
    public void withoutError() {
        when(database.getClientByOrderId(5l)).thenReturn(new Client());
        List<CoreError> coreErrors = orderIdValidator.validate(5l);
        assertEquals(coreErrors, List.of());
    }

}
