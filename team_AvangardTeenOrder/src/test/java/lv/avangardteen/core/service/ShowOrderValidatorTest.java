package lv.avangardteen.core.service;

import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.OrderIdValidator;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowOrderValidatorTest {
    @Mock
    private Database database;
    @Mock
    private OrderIdValidator idValidator;
    @InjectMocks
    private ShowOrderValidator validator;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void notErrors() {
        ShowOrderRequest request = new ShowOrderRequest(1l);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of());
        Mockito.when(database.getClientByOrderId(request.getId())).thenReturn(new Client());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void isErrors() {
        ShowOrderRequest request = new ShowOrderRequest(1l);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of());
        Mockito.when(database.getClientByOrderId(request.getId())).thenReturn(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void orderIsAbsent() {
        ShowOrderRequest request = new ShowOrderRequest(1l);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of(new CoreError(
                "error", "message")));
        Mockito.when(database.getClientByOrderId(request.getId())).thenReturn(new Client());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

}
