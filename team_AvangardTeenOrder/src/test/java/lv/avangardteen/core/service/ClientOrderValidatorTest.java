package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.service.validate.ClientOrderValidator;
import lv.avangardteen.core.service.validate.ComponentValidator;
import lv.avangardteen.core.service.validate.PersonalDateValidation;
import lv.avangardteen.core.service.validate.PersonalSizeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ClientOrderValidatorTest {

    private PersonalDateValidation personalDateValidation;
    private PersonalSizeValidator personalSizeValidator;
    private ComponentValidator componentValidator;
    private ClientOrderValidator validator;

    @BeforeEach
    public void init() {

        personalDateValidation = Mockito.mock(PersonalDateValidation.class);
        personalSizeValidator = Mockito.mock(PersonalSizeValidator.class);
        componentValidator = Mockito.mock(ComponentValidator.class);
        validator = new ClientOrderValidator(personalDateValidation, personalSizeValidator, componentValidator);
    }


    @Test
    public void shouldNotReturnErrorsWhenPersonalDateReturnNoErrors() {
        ClientRequest request = new ClientRequest("Ivan",
                1234, "Lesnaja", 33, 33, 33, 33,
                11, 21, 31, 41);
        when(personalDateValidation.validate(request.getNameSurname(),
                request.getPhoneNumber(), request.getUserAddress())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenPersonalDateReturnErrors() {
        ClientRequest request = new ClientRequest("Ivan",
                1234, "Lesnaja", 33, 33, 33, 33,
                11, 21, 31, 41);
        when(personalDateValidation.validate(request.getNameSurname(),
                request.getPhoneNumber(), request.getUserAddress())).thenReturn(List.of(
                new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }

    @Test
    public void shouldReturnErrorsWhenPersonalSizeValidatorReturnErrors() {
        ClientRequest request = new ClientRequest("Ivan",
                1234, "Lesnaja", 33, 0, 33, 33,
                11, 21, 31, 41);
        when(personalSizeValidator.validate(request.getUserSizes())).thenReturn(List.of(new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);

    }

    @Test
    public void shouldNotReturnErrorsWhenPersonalSizeValidatorReturnNoErrors() {
        ClientRequest request = new ClientRequest("Ivan",
                1234, "Lesnaja", 33, 33, 33, 33,
                11, 21, 31, 41);
        when(personalSizeValidator.validate(request.getUserSizes())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);

    }

    @Test
    public void shouldNotReturnErrorsWhenComponentValidatorReturnNoErrors() {
        ClientRequest request = new ClientRequest("Ivan",
                1234, "Lesnaja", 33, 33, 33, 33,
                11, 21, 31, 41);
        when(componentValidator.validate(request.getWheelchairComponent())).thenReturn(List.of());
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorsWhenComponentValidatorReturnErrors() {
        ClientRequest request = new ClientRequest("Ivan",
                1234, "Lesnaja", 33, 33, 33, 33,
                11, 21, 31, 41);
        when(componentValidator.validate(request.getWheelchairComponent()))
                .thenReturn(List.of(new CoreError("errors", "message")));
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
    }


}