package lv.avangardteen.core.service;


import lv.avangardteen.core.DatabaseCleaner;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.core.database.*;
import lv.avangardteen.core.domain.*;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.validate.ShowOrderValidator;
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
class ShowOrderServiceTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private ShowOrderService service;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private ShowOrderValidator validator;
    @Autowired
    private Database database;
    @Autowired
    private UserSizeDb userSizeDb;
    @Autowired
    private CalculateDimensionsWheelchair dimensionsWheelchair;
    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private WComponentsDB wComponentsDB;


    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void ShowOrderWithError() {
        Client client = new Client("MMM", 9999l, 9999l, "LLLL");
        database.addUser(client);
        UserSizes userSizes = new UserSizes();
        userSizes.setClient(client);
        userSizes.setThighLength(22);
        userSizes.setPelvisWidth(22);
        userSizes.setBackHeight(22);
        userSizes.setShinLength(22);
        userSizeDb.addUserSize(userSizes);
        Wheelchair wheelchair = dimensionsWheelchair.setDimensions(22, 22, 22, 22);
        wheelchair.setClient(client);
        wheelchairDB.addWheelchair(wheelchair);
        Wheelchair wheelchair1 = wheelchairDB.getWheelchair(1L);
        Components components1 = new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1);
        Components components2 = new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2);
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

        ShowOrderRequest request = new ShowOrderRequest(1L);
        ShowOrderResponse response = service.execute(request);

        assertEquals(response.getPriceComponents(), 11.0);
        System.out.println(response.toString());
        System.out.println(response.getWheelchair().toString());
        System.out.println(response.getWheelchairComponents().toString());
        System.out.println("Стоимость Avangard Teen: " +
                response.getPriceWheelchair());
        System.out.println("Стоимость компонентов: " +
                response.getPriceComponents());
        System.out.println("Цена заказа: " +
                response.getPriceOrder());
    }


}
