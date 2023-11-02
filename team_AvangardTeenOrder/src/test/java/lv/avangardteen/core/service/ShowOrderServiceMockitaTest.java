package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShowOrderServiceMockitaTest {
    private ShowOrderService service;
    private Database database;
    private ShowOrderValidator validator;

    @Test
    public void ShowOrderWithError(){
        ShowOrderRequest notValidRequest = new ShowOrderRequest(1);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ShowOrderValidator.class);
        Mockito.when(validator.validate(notValidRequest)).thenReturn(List.of(
                new CoreError("Show Order", "Incorrect ID number!")));
        service = new ShowOrderService(database,validator);
        ShowOrderResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ShowOrderWithoutError(){
        ShowOrderRequest request = new ShowOrderRequest(1);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ShowOrderValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        service = new ShowOrderService(database,validator);
        ShowOrderResponse response = service.execute(request);
        assertFalse(response.hasErrors());
    }

}