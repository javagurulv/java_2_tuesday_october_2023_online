package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import lv.avangardteen.core.data.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShowOrderServiceMockitaTest {

    @Mock
    private ShowOrderValidator validator;
    @Mock
    private Database database;
    @InjectMocks
    private ShowOrderService service;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void ShowOrderWithError() {
        ShowOrderRequest notValidationRequest = new ShowOrderRequest(1L);
        Mockito.when(validator.validate(notValidationRequest)).thenReturn(List.of(
                new CoreError("Show Order", "Incorrect ID number!")));
        ShowOrderResponse response = service.execute(notValidationRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void ShowOrderWithoutError() {
        ShowOrderRequest request = new ShowOrderRequest(1L);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        ShowOrderResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).getClient(request.getId());
    }


}