package lv.avangardteen.core.service;
/*

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.core.service.validate.OrderIdValidator;
import lv.avangardteen.core.service.validate.PersonalSizeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChangePersonalSizeValidatorTest {
    @Mock
    private OrderIdValidator idValidator;
    @Mock
    private PersonalSizeValidator personalSizeValidator;
    @InjectMocks
    private ChangePersonalSizeValidator validator;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void shouldNotReturnErrorsWhenIdValidatorReturnNoErrors() {

        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(2l,
                33, 33, 33, 33);
        when(idValidator.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);

    }

    @Test
    public void shouldReturnErrorsWhenIdValidatorReturnErrors() {

        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(2l,
                33, 33, 33, 33);
        when(idValidator.validate(request.getId())).thenReturn(List.of(new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);

    }

    @Test
    public void shouldReturnErrorsWhenPersonalSizeValidatorReturnErrors() {
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(2l,
                0, 33, 33, 33);
        when(personalSizeValidator.validate(request.getUserSizes())).thenReturn(List.of(new CoreError("error", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);


    }

    @Test
    public void shouldNotReturnErrorsWhenPersonalSizeValidatorReturnNoErrors() {
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(2l,
                33, 33, 33, 33);
        when(personalSizeValidator.validate(request.getUserSizes())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);

    }
}*/
