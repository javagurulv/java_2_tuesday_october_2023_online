package lv.avangardteen.core.service;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.IdOrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IdOrderValidatorTest {

    @Mock
    private ClientIdValidator validatorId;
    @InjectMocks
    private IdOrderValidator validator;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void notErrors() {
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        Mockito.when(validatorId.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void isErrors() {
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        Mockito.when(validatorId.validate(request.getId())).thenReturn(List.of(
                new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

}