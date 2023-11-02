package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShowOrderValidatorTest {

private ShowOrderValidator validator;

    @Test
    public void getUserTest() {
        Database database = Mockito.mock(Database.class);
        ShowOrderRequest request = Mockito.mock(ShowOrderRequest.class);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        validator = new ShowOrderValidator(database);

        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idClient");
        assertEquals(validList.get(0).getMessage(),"Order with this id not found!");
    }
}