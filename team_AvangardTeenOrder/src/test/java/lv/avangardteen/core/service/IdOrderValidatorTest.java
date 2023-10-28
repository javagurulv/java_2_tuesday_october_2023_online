package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IdOrderValidatorTest {
    private IdOrderValidator validator = new IdOrderValidator();


    @Test
    public void getUserTest() {
        DeleteOrderRequest request = mock(DeleteOrderRequest.class);
        when(request.getId()).thenReturn(0);
        List<CoreError> validList = validator.validate(request);
        assertEquals(validList.size(), 1);
        assertEquals(validList.get(0).getField(), "idOrder");
        assertEquals(validList.get(0).getMessage(),"Must not be empty!");
    }

}