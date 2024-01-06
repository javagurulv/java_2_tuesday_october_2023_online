package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderIdValidatorTest {
    @Mock
    private Database database;
    @InjectMocks
    private OrderIdValidator idValidator;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getIdIsAbsent() {
        Mockito.when(database.getClientById(1l)).thenReturn(new Client());
        List<CoreError> errors = idValidator.validate(null);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void getIdIsNull() {
        Mockito.when(database.getClientById(1l)).thenReturn(new Client());
        List<CoreError> errors = idValidator.validate(0l);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void getClientIsAbsent() {
        Mockito.when(database.getClientById(1l)).thenReturn(null);
        List<CoreError> errors = idValidator.validate(1l);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void getClientIsPresent() {
        Mockito.when(database.getClientById(1l)).thenReturn(new Client());
        List<CoreError> errors = idValidator.validate(1l);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void getClientIsNull() {
        Mockito.when(database.getClientById(1l)).thenReturn(new Client());
        List<CoreError> errors = idValidator.validate(2l);
        assertEquals(errors.size(), 1);
    }

}