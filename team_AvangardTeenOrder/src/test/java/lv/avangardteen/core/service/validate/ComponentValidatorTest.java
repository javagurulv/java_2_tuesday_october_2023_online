package lv.avangardteen.core.service.validate;

/*
import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.database.OrmDataComponentsImpl;
import lv.avangardteen.core.database.WComponentsDB;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Ignore
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DataComponents.class})
@Sql({"/schema.sql"})
class ComponentValidatorTest {
    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private ComponentValidator componentValidator;
    @Autowired
    private OrmDataComponentsImpl dataComponents;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void wheelFrontChooseIsAbsent() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(0, 4, 1, 2, 3);
        componentValidator = new ComponentValidator();

        Components components = dataComponents.getComponent(1);
        assertEquals(1, components.getId());


        List<CoreError> errors = componentValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }*/


   /* @Test
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
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(11, 21, 0, 41);
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

   } }*/




