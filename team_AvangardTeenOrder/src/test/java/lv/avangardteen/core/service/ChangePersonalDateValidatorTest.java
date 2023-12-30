package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ChangePersonalDateValidator;
import lv.avangardteen.core.service.validate.OrderIdValidator;
import lv.avangardteen.core.service.validate.PersonalDateValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class ChangePersonalDateValidatorTest {

    @Mock
    private OrderIdValidator idValidator;
    @Mock
    private PersonalDateValidation personalDateValidation;
    @InjectMocks
    private ChangePersonalDateValidator validator;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldNotReturnErrorsWhenIdValidatorReturnNoErrors() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(2l,
                "Ivanov", 111l, 3343534l, "Lesnaja, 22");
        when(idValidator.validate(request.getId())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenIdValidatorReturnErrors() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(2l,
                "Ivanov", 111l, 3343534l, "Lesnaja, 22");
        when(idValidator.validate(request.getId())).thenReturn(List.of(
                new CoreError("errors", "message")));

        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void shouldNotReturnErrorsWhenPersonalDateReturnNoErrors() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(2l,
                "Ivanov", 111l, 3343534l, "Lesnaja, 22");
        when(personalDateValidation.validate(request.getUserRegistration())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPersonalDateReturnErrors() {
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(2l,
                "Ivanov", 111l, 3343534l, "Lesnaja, 22");
        when(personalDateValidation.validate(request.getUserRegistration())).thenReturn(List.of(
                new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }
}