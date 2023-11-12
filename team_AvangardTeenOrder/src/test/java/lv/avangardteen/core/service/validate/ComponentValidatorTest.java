package lv.avangardteen.core.service.validate;


import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentValidatorTest {

    private ComponentValidator validator;


    @Test
    public void wheelFrontChooseIsAbsent() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l, 0, 21, 31, 41);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request.getWheelchairComponent());
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
    }

    @Test
    public void indexBackWheelIsAbsent() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l, 11, 0, 31, 41);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request.getWheelchairComponent());
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBackWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public void indexBrakeIsAbsent() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l, 11, 21, 0, 41);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request.getWheelchairComponent());
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");


    }

    @Test
    public void indexArmrestIsAbsent() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l, 11, 21, 31, null);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request.getWheelchairComponent());
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexArmrest");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public void indexBrakeAndArmrestIsAbsent() {
        ChangeComponentRequest request = new ChangeComponentRequest(2l, 11, 22, 138, 141);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request.getWheelchairComponent());
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
        assertEquals(errors.get(1).getField(), "indexArmrest");
        assertEquals(errors.get(1).getMessage(), "This index is absent!");

    }
}