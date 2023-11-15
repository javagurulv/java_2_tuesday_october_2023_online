package lv.avangardteen.core.service;

import lv.avangardteen.dto.Client;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.DeleteOrderResponse;
import lv.avangardteen.core.service.validate.IdOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteOrderServiceMockitaTest {

    @Mock
    private Database database;
    @Mock
    private IdOrderValidator validator;
    @InjectMocks
    private DeleteOrderService service;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void DeleteOrderWithError() {
        DeleteOrderRequest notValidationRequest = new DeleteOrderRequest(1L);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(
                List.of(new CoreError("Delete Order", "Incorrect ID number!")));
        DeleteOrderResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void DeleteOrderWithoutError() {
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        DeleteOrderResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).deleteUser(request.getId());

    }

}