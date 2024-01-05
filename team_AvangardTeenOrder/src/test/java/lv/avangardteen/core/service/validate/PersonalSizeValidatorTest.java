package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalSizeValidatorTest {
    private UserSizeRegistrationRequest request;
    private PersonalSizeValidator personalSizeValidator;


    @Test
    public void errorsIsEmpty() {

        request =  new UserSizeRegistrationRequest(22, 33, 33, 33);

        personalSizeValidator = new PersonalSizeValidator();


        List<CoreError> errors1 = personalSizeValidator.validate(request.getUserSizes());

        assertEquals(errors1,List.of());
    }

    @Test
    public void pelvisWidthIsEmpty() {
        request =  new UserSizeRegistrationRequest(null, 33, 33, 33);
        personalSizeValidator = new PersonalSizeValidator();

        List<CoreError> errors = personalSizeValidator.validate(request.getUserSizes());
        assertEquals(errors, List.of(new CoreError("pelvisWidth", "Must not be empty!")));
    }

    @Test
    public void thighLengthIsEmpty() {
        request =  new UserSizeRegistrationRequest(null, null, 33, 33);
        personalSizeValidator = new PersonalSizeValidator();

        List<CoreError> errors = personalSizeValidator.validate(request.getUserSizes());
        assertEquals(errors, List.of(new CoreError("pelvisWidth", "Must not be empty!"),
                new CoreError("thighLength", "Must not be empty!")));
    }

    @Test
    public void backHeightIsEmpty() {
        request =  new UserSizeRegistrationRequest(33, 33, null, 33);
        personalSizeValidator = new PersonalSizeValidator();

        List<CoreError> errors = personalSizeValidator.validate(request.getUserSizes());
        assertEquals(errors, List.of(new CoreError("backHeight", "Must not be empty!")));

    }

    @Test
    public void shinLengthIsEmpty() {
        request =  new UserSizeRegistrationRequest(33, 33, 33, null);
        personalSizeValidator = new PersonalSizeValidator();

        List<CoreError> errors = personalSizeValidator.validate(request.getUserSizes());
        assertEquals(errors, List.of(new CoreError("shinLength", "Must not be empty!")));

    }

    @Test
    public void listErrors() {
        request =  new UserSizeRegistrationRequest(0, 0, 0, 0);
        personalSizeValidator = new PersonalSizeValidator();

        List<CoreError> errors = personalSizeValidator.validate(request.getUserSizes());
        assertEquals(errors.size(), 4);

    }


}
