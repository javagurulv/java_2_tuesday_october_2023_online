package lv.avangardteen.core.database;

import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;
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
class WheelchairComponentsRepositoryTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private Database database;
    @Autowired
    private WComponentsDB wComponentsDB;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void wheelchairTest() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        database.addUser(client1);

        Wheelchair wheelchair = new Wheelchair();
        wheelchair.setClient(client1);
        wheelchair.setPrice(177000.0);
        wheelchair.setBachHeight(22);
        wheelchair.setFootrestLength(22);
        wheelchair.setSeatDepth(22);
        wheelchair.setSeatWidth(22);
        wheelchairDB.addWheelchair(wheelchair);

        Components components1 = new Components("FRONT-WHEEL", "MH01", "INFORMATION", 1.1);
        Components components2 = new Components("BACK-WHEEL", "MN01", "INFORMATION1", 2.2);
        Components components3 = new Components("BRAKE", "MF01", "INFORMATION2", 3.3);
        Components components4 = new Components("FOOTREST", "MK01", "INFORMATION3", 4.4);

        dataComponents.addComponent(components1);
        dataComponents.addComponent(components2);
        dataComponents.addComponent(components3);
        dataComponents.addComponent(components4);

        List<Wheelchair> wheelchairList = wheelchairDB.getWheelchairsList();
        assertEquals(wheelchairList.size(), 1);
        WheelchairComponents wheelchairComponents1 = new WheelchairComponents();
        wheelchairComponents1.setWheelchair(wheelchair);
        wheelchairComponents1.setComponents(components1);
        wheelchairComponents1.setPriceComponent(components1.getPrice());
        WheelchairComponents wheelchairComponents2 = new WheelchairComponents();
        wheelchairComponents2.setWheelchair(wheelchair);
        wheelchairComponents2.setComponents(components2);
        wheelchairComponents2.setPriceComponent(components2.getPrice());
        WheelchairComponents wheelchairComponents3 = new WheelchairComponents();
        wheelchairComponents3.setWheelchair(wheelchair);
        wheelchairComponents3.setComponents(components3);
        wheelchairComponents3.setPriceComponent(components3.getPrice());
        WheelchairComponents wheelchairComponents4 = new WheelchairComponents();
        wheelchairComponents4.setWheelchair(wheelchair);
        wheelchairComponents4.setComponents(components4);
        wheelchairComponents4.setPriceComponent(components4.getPrice());

        wComponentsDB.addWheelchairComponents(wheelchairComponents1);
        wComponentsDB.addWheelchairComponents(wheelchairComponents2);
        wComponentsDB.addWheelchairComponents(wheelchairComponents3);
        wComponentsDB.addWheelchairComponents(wheelchairComponents4);

        System.out.println(wComponentsDB.getChooseComponents(wheelchair));
        List<WheelchairComponents> list = wComponentsDB.getChooseComponents(wheelchair);
        assertEquals(list.size(), 4);
    }
}
