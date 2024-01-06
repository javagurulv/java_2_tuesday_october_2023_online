package lv.avangardteen.core.service.validate;


import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {
    @Mock
    private Database database;
    @InjectMocks
    private OrderValidator validator;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getResponseWithErrorsClientNotFound() {

        OrderRequest request = new OrderRequest("Petrov", 111L, 22, 22, 22, 22);
        Mockito.when(database.findBySurnameAndPersonalCode("Petrov", 111L)).thenReturn(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        Mockito.verify(database).findBySurnameAndPersonalCode( "Petrov", 111L);
       assertEquals(errors, List.of(new CoreError("clientAbsent", "Client must be registered!")));
    }

    @Test
    public void getResponseWithErrorsParameter1IsNull() {
        Client client = new Client("Petrov", 111L, 222L, "vvv");
        OrderRequest request = new OrderRequest("Petrov", 111L, null, 22, 22, 22);
        Mockito.when(database.findBySurnameAndPersonalCode("Petorv", 111L)).thenReturn(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        Mockito.verify(database).findBySurnameAndPersonalCode( "Petrov", 111L);
         assertEquals(errors, List.of(new CoreError("pelvisWidth", "Must not be empty!")));
    }


    @Test
    public void getResponseWithErrorsParameter2IsNull() {
        Client client = new Client("Petrov", 111L, 222L, "vvv");
        OrderRequest request = new OrderRequest("Petrov", 111L, 22, null, 22, 22);
        Mockito.when(database.findBySurnameAndPersonalCode("Petorv", 111L)).thenReturn(client);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        Mockito.verify(database).findBySurnameAndPersonalCode( "Petrov", 111L);
        // assertEquals(errors, List.of(new CoreError("surname", "Must not be empty!")));
    }
}
