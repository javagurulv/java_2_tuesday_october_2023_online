package lv.avangardteen.core.service;


import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShowOrderValidatorTest {
    private ClientIdValidator idValidator;
    private ShowOrderValidator validator;

    @BeforeEach
    public void init() {
        idValidator = Mockito.mock(ClientIdValidator.class);
        validator = new ShowOrderValidator(idValidator);
    }

    @Test
    public void notErrors() {
        ShowOrderRequest request = new ShowOrderRequest(1L);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void isErrors() {
        ShowOrderRequest request = new ShowOrderRequest(1L);
        Mockito.when(idValidator.validate(request.getId())).thenReturn(List.of(
                new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

}