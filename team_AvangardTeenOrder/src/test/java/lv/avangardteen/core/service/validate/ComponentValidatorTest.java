package lv.avangardteen.core.service.validate;

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ComponentValidatorTest {
    @Mock
    private DataComponents dataComponents;
    @InjectMocks
    private ComponentValidator validator;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void wheelFrontChooseIsAbsent() {
        dataComponents = Mockito.mock(DataComponents.class);
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(11, 21, 31, 41);
        when(dataComponents.allFrontWheels()).thenReturn(List.of());
        when(dataComponents.allBackWheels()).thenReturn(List.of(new Components()));
        when(dataComponents.allBrakes()).thenReturn(List.of(new Components()));
        when(dataComponents.allFootrest()).thenReturn(List.of(new Components()));
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
    }

    @Test
    public void indexBackWheelIsAbsent() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(11, 0, 31, 41);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBackWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public void indexBrakeIsAbsent() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest( 11, 21, 0, 41);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");


    }

    @Test
    public void indexArmrestIsAbsent() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(11, 21, 31, null);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexArmrest");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public void indexBrakeAndArmrestIsAbsent() {
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(11, 22, 138, 141);
        validator = new ComponentValidator();
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
        assertEquals(errors.get(1).getField(), "indexArmrest");
        assertEquals(errors.get(1).getMessage(), "This index is absent!");

    }
}
