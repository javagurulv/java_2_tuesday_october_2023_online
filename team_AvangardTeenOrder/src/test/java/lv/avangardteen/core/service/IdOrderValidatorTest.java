package lv.avangardteen.core.service;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.IdOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IdOrderValidatorTest {
    private Database database;
    private ClientIdValidator validatorId;
    private IdOrderValidator validator;


    @Test
    public void getUserTest() {
        database = mock(Database.class);
        validatorId = new ClientIdValidator(database);
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        validator = new IdOrderValidator(validatorId);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(),"Order with this id not found!");
    }

    @Test
    public void getIdIsZero() {
        database = mock(Database.class);
        validatorId = new ClientIdValidator(database);
        DeleteOrderRequest request = new DeleteOrderRequest(0l);
        validator = new IdOrderValidator(validatorId);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(),"Must not be empty!");
    }

    @Test
    public void getIdIsNull() {
        database = mock(Database.class);
        validatorId = new ClientIdValidator(database);
        DeleteOrderRequest request = Mockito.mock(DeleteOrderRequest.class);
        Mockito.when(request.getId()).thenReturn(null);
        validator = new IdOrderValidator(validatorId);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(),"Must not be empty!");
    }

}