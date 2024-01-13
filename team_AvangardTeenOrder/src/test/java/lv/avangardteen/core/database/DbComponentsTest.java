package lv.avangardteen.core.database;

import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.core.domain.Components;
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
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
class DbComponentsTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private DataComponents dataComponents;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void getListComponentsWheelFront() {
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH02", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN03", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF02", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK02", "INFORMATION3", 4.4));

        List<Components> componentsList = dataComponents.allFrontWheels();
        assertEquals(componentsList.size(), 2);

        System.out.println(componentsList.toString());
    }

    @Test
    public void getListComponentsWheelBack() {
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH02", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN03", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF02", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK02", "INFORMATION3", 4.4));

        List<Components> componentsList = dataComponents.allBackWheels();
        assertEquals(componentsList.size(), 2);

        System.out.println(componentsList.toString());
    }

    @Test
    public void getListComponentsBrake() {
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH02", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN03", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF02", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK02", "INFORMATION3", 4.4));

        List<Components> componentsList = dataComponents.allBrakes();
        assertEquals(componentsList.size(), 2);

        System.out.println(componentsList.toString());
    }

    @Test
    public void getListComponentsFootrest() {
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH02", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN03", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF02", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK02", "INFORMATION3", 4.4));

        List<Components> componentsList = dataComponents.allFootrest();
        assertEquals(componentsList.size(), 2);

        System.out.println(componentsList.toString());
    }

    @Test
    public void getListComponents() {
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH02", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN03", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF02", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK02", "INFORMATION3", 4.4));

        List<Components> componentsList = dataComponents.getAllComponents();
        assertEquals(componentsList.size(), 8);

        System.out.println(componentsList.toString());
    }

    @Test
    public void getComponents() {
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));
        dataComponents.addComponent(new Components("FRONT-WHEEL", "MH02", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK-WHEEL", "MN03", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF02", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK02", "INFORMATION3", 4.4));

        Components components = dataComponents.getComponent(3);
        assertEquals(components.getCategory(),"BRAKE");

        System.out.println(components.toString());
    }
}