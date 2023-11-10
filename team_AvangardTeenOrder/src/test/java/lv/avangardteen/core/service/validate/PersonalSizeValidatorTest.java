package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonalSizeValidatorTest {

    private PersonalSizeValidator personalSizeValidator;

    @Test
    public void errorsIsEmpty() {
        personalSizeValidator = new PersonalSizeValidator();
        Integer pelvisWidth = 33;
        Integer thighLength = 33;
        Integer backHeight = 33;
        Integer shinLength = 33;
        List<CoreError> errors = personalSizeValidator.validate(pelvisWidth,
                thighLength, backHeight, shinLength);
        assertEquals(errors, List.of());
    }

    @Test
    public void pelvisWidthIsEmpty() {
        personalSizeValidator = new PersonalSizeValidator();
        Integer pelvisWidth = null;
        Integer thighLength = 33;
        Integer backHeight = 33;
        Integer shinLength = 33;
        List<CoreError> errors = personalSizeValidator.validate(pelvisWidth,
                thighLength, backHeight, shinLength);
        assertEquals(errors, List.of(new CoreError("pelvisWidth", "Must not be empty!")));
    }

    @Test
    public void thighLengthIsEmpty() {
        personalSizeValidator = new PersonalSizeValidator();
        Integer pelvisWidth = null;
        Integer thighLength = 0;
        Integer backHeight = 33;
        Integer shinLength = 33;
        List<CoreError> errors = personalSizeValidator.validate(pelvisWidth,
                thighLength, backHeight, shinLength);
        assertEquals(errors, List.of(new CoreError("pelvisWidth", "Must not be empty!"),
                new CoreError("thighLength", "Must not be empty!")));
    }

    @Test
    public void  backHeightIsEmpty() {
        personalSizeValidator = new PersonalSizeValidator();
        Integer pelvisWidth = 33;
        Integer thighLength = 33;
        Integer backHeight = 0;
        Integer shinLength = 33;
        List<CoreError> errors = personalSizeValidator.validate(pelvisWidth,
                thighLength, backHeight, shinLength);
        assertEquals(errors, List.of(new CoreError("backHeight", "Must not be empty!")));

    }

    @Test
    public void shinLengthIsEmpty() {
        personalSizeValidator = new PersonalSizeValidator();
        Integer pelvisWidth = 33;
        Integer thighLength = 33;
        Integer backHeight = 33;
        Integer shinLength = null;
        List<CoreError> errors = personalSizeValidator.validate(pelvisWidth,
                thighLength, backHeight, shinLength);
        assertEquals(errors, List.of(new CoreError("shinLength", "Must not be empty!")));

    }

    @Test
    public void listErrors() {
        personalSizeValidator = new PersonalSizeValidator();
        Integer pelvisWidth = 0;
        Integer thighLength = 0;
        Integer backHeight = null;
        Integer shinLength = null;
        List<CoreError> errors = personalSizeValidator.validate(pelvisWidth,
                thighLength, backHeight, shinLength);
        assertEquals(errors.size(), 4);

    }



}