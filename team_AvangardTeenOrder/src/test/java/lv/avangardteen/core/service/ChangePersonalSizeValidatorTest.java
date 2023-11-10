package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalSizeValidator;
import lv.avangardteen.core.service.validate.ClientIdValidator;
import lv.avangardteen.core.service.validate.PersonalSizeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChangePersonalSizeValidatorTest {
    private ClientIdValidator idValidator;
    private PersonalSizeValidator personalSizeValidator;
    private ChangePersonalSizeValidator validator;

    @BeforeEach
    public void init() {
        idValidator = Mockito.mock(ClientIdValidator.class);
        personalSizeValidator = Mockito.mock(PersonalSizeValidator.class);
        validator = new ChangePersonalSizeValidator(idValidator, personalSizeValidator);
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
                33, 33, 33, 33);
        when(personalSizeValidator.validate(request.getPelvisWidth(),
                request.getThighLength(), request.getBackHeight(),
                request.getShinLength())).thenReturn(List.of(new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);

    }

    @Test
    public void shouldNotReturnErrorsWhenPersonalSizeValidatorReturnNoErrors() {
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(2l,
                33, 33, 33, 33);
        when(personalSizeValidator.validate(request.getPelvisWidth(),
                request.getThighLength(), request.getBackHeight(),
                request.getShinLength())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);

    }
}