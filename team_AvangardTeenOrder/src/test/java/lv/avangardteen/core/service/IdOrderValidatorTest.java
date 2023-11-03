package lv.avangardteen.core.service;

import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.IdOrderValidator;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class IdOrderValidatorTest {

    private ClientIdValidator validatorId;
    private IdOrderValidator validator;


    @BeforeEach
    public void init() {
        validatorId = Mockito.mock(ClientIdValidator.class);
        validator = new IdOrderValidator(validatorId);
    }

    @Test
    public void notErrors() {
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        Mockito.when(validatorId.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void  isErrors() {
        DeleteOrderRequest request = new DeleteOrderRequest(1L);
        Mockito.when(validatorId.validate(request.getId())).thenReturn(List.of(
                new CoreError("errors", "message") ));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

}