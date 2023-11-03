package lv.avangardteen.core.service;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.IdOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IdOrderValidatorTest {
    private Database database;
    private IdOrderValidator validator;


    @Test
    public void getUserTest() {
        database = mock(Database.class);
        DeleteOrderRequest request = mock(DeleteOrderRequest.class);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        validator = new IdOrderValidator(database);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(),"Order with this id not found!");
    }

}