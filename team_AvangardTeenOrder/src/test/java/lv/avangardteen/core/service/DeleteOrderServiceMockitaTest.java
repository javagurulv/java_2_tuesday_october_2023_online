package lv.avangardteen.core.service;

import lv.avangardteen.dto.Client;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.DeleteOrderResponse;
import lv.avangardteen.core.service.validate.IdOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteOrderServiceMockitaTest {

    private DeleteOrderService service;
    private Database database;
    private IdOrderValidator validator;
    @Test
    public void DeleteOrderWithError(){
        DeleteOrderRequest notValidationRequest = new DeleteOrderRequest(1L);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(IdOrderValidator.class);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(
                List.of(new CoreError("Delete Order", "Incorrect ID number!")));
        service = new DeleteOrderService(database,validator);
        DeleteOrderResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void DeleteOrderWithoutError(){
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        database = Mockito.mock(Database.class);
        validator = Mockito.mock(IdOrderValidator.class);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        service = new DeleteOrderService(database,validator);
        DeleteOrderResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).deleteUser(request.getId());

    }

}