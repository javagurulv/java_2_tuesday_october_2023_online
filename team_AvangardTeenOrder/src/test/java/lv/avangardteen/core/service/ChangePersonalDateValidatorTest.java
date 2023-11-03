package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChangePersonalDateValidatorTest {

    private ChangePersonalDateValidator validator;

    @Test
    public void clientNotFound() {
        Database database = Mockito.mock(Database.class);
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1L,
                "Ivanov", 3343534, "Lesnaja, 22");
        validator = new ChangePersonalDateValidator(database);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(), "Order with this id not found!");
    }

    @Test
    public void addressIsEmpty() {
        Database database = Mockito.mock(Database.class);
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1L,
                "Ivanov", 3343534, "");
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        validator = new ChangePersonalDateValidator(database);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "userAddress");
        assertEquals(validList.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void surnameAndPhoneIsEmpty() {
        Database database = Mockito.mock(Database.class);
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1L,
                "", null, "Lesnaja, 22");
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        validator = new ChangePersonalDateValidator(database);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 2);
        assertEquals(validList.get(0).getField(), "nameSurname");
        assertEquals(validList.get(0).getMessage(), "Must not be empty!");
        assertEquals(validList.get(1).getField(), "phoneNumber");
        assertEquals(validList.get(1).getMessage(), "Must not be zero!");
    }
}