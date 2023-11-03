package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChangePersonalSizeValidatorTest {

    private ChangePersonalSizeValidator validator;

    @Test
    public void clientNotFound() {
        Database database = Mockito.mock(Database.class);
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(1L,
                44, 44, 44, 44);
        validator = new ChangePersonalSizeValidator(database);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(), "Order with this id not found!");
    }

    @Test
    public void allSizeIsZero() {
        Database database = Mockito.mock(Database.class);
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(1L,
                0, 0, 0, 0);
        validator = new ChangePersonalSizeValidator(database);
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 4);
        assertEquals(validList.get(0).getField(), "pelvisWidth");
        assertEquals(validList.get(0).getMessage(), "Must not be empty!");
        assertEquals(validList.get(1).getField(), "thighLength");
        assertEquals(validList.get(1).getMessage(), "Must not be empty!");
        assertEquals(validList.get(2).getField(), "backHeight");
        assertEquals(validList.get(2).getMessage(), "Must not be empty!");
        assertEquals(validList.get(3).getField(), "shinLength");
        assertEquals(validList.get(3).getMessage(), "Must not be empty!");
    }
}