package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.ComponentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChooseComponentValidatorTest {
    private ClientIdValidator idValidator;
    private ComponentValidator componentValidator;
    private ChooseComponentValidator validator;

    @BeforeEach
    public void init() {
        idValidator = Mockito.mock(ClientIdValidator.class);
        componentValidator = Mockito.mock(ComponentValidator.class);
        validator = new ChooseComponentValidator(idValidator, componentValidator);
    }

    @Test
    public void shouldNotReturnErrorsWhenIdValidatorReturnNoErrors() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l,
                11, 21, 31, 41);
        when(idValidator.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenIdValidatorReturnErrors() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l,
                11, 21, 31, 41);
        when(idValidator.validate(request.getId())).thenReturn(List.of(new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void shouldNotReturnErrorsWhenComponentValidatorReturnNoErrors() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l,
                11, 21, 31, 41);
        when(componentValidator.validate(request.getWheelchairComponent())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenComponentValidatorReturnErrors() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l,
                11, 21, 31, 41);
        when(componentValidator.validate(request.getWheelchairComponent()))
                .thenReturn(List.of(new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

}