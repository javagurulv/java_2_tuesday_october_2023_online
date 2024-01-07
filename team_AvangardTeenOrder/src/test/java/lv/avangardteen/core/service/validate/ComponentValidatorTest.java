package lv.avangardteen.core.service.validate;


import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.config.OrderListConfiguration;
import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.database.Database;
import lv.avangardteen.core.database.OrmDataComponentsImpl;
import lv.avangardteen.core.database.WComponentsDB;
import lv.avangardteen.core.domain.Client;
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
@ContextConfiguration(classes = {OrderListConfiguration.class})
@Sql({"/schema.sql"})
class ComponentValidatorTest {
    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private ComponentValidator componentValidator;
    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private Database database;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void notErrors() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));

        Components components = dataComponents.getComponent(1);
        System.out.println(components.toString());
        assertEquals("MH01", components.getMarking());
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1L, 1, 2, 3, 4);
        List<CoreError> errors = componentValidator.validate(request);
        assertEquals(errors.size(), 0);
    }



    @Test
    public void indexBackWheelIsAbsent() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));

        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1L,11, 2, 3, 4);

        List<CoreError> errors = componentValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }
    @Test
    public void indexBrakeIsAbsent() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1L, 1, 2, 32,4);

        List<CoreError> errors = componentValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
    }

    @Test
    public void indexFootrestIsAbsent() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1L, 1, 2, 3, null);
              List<CoreError> errors = componentValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFootrest");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }
    @Test
    public void indexBrakeAndArmrestIsAbsent() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        ComponentRegistrationRequest request = new ComponentRegistrationRequest(
                1L, 2, 2, 14, 5);


        List<CoreError> errors = componentValidator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 3);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
        assertEquals(errors.get(1).getField(), "indexBrake");
        assertEquals(errors.get(1).getMessage(), "This index is absent!");
        assertEquals(errors.get(2).getField(), "indexFootrest");
        assertEquals(errors.get(2).getMessage(), "This index is absent!");

    }
}



