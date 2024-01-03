package lv.avangardteen.core.service;
/*

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChooseComponentValidator;
import lv.avangardteen.core.service.validate.OrderIdValidator;
import lv.avangardteen.core.service.validate.ComponentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChooseComponentValidatorTest {
    @Mock
    private OrderIdValidator idValidator;
    @Mock
    private ComponentValidator componentValidator;
    @InjectMocks
    private ChooseComponentValidator validator;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
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

}*/
