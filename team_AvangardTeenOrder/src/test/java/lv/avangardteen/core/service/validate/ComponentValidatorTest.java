package lv.avangardteen.core.service.validate;


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
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ComponentValidator(dataComponents);
        List<CoreError> errors = validator.validate(null, 21, 31, 41);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
    }

    @Test
    public void indexBackWheelIsAbsent() {
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ComponentValidator(dataComponents);
        List<CoreError> errors = validator.validate(11, 0, 31, 41);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBackWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public void indexBrakeIsAbsent() {

        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ComponentValidator(dataComponents);
        List<CoreError> errors = validator.validate(11, 21, 35, 41);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");


    }

    @Test
    public void indexArmrestIsAbsent() {
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ComponentValidator(dataComponents);
        List<CoreError> errors = validator.validate(11, 21, 31, 43);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexArmrest");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public void indexBrakeAndArmrestIsAbsent() {

        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ComponentValidator(dataComponents);
        List<CoreError> errors = validator.validate(11, 21, null, 0);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
        assertEquals(errors.get(1).getField(), "indexArmrest");
        assertEquals(errors.get(1).getMessage(), "This index is absent!");

    }
}