package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
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
        ShowOrderRequest notValidationRequest = new ShowOrderRequest(1L);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ShowOrderValidator.class);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(List.of(
                new CoreError("Show Order", "Incorrect ID number!")));
        service = new ShowOrderService(database,validator);
        ShowOrderResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ShowOrderWithoutError(){
        ShowOrderRequest request = new ShowOrderRequest(1L);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(ShowOrderValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        service = new ShowOrderService(database,validator);
        ShowOrderResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).getClient(request.getId());
    }

}