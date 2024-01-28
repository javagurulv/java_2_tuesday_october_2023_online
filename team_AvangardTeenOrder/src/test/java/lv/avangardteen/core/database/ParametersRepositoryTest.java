package lv.avangardteen.core.database;

import lv.avangardteen.core.DatabaseCleaner;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.service.CalculateDimensionsWheelchair;
import lv.avangardteen.core.service.UserRegistrationService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@Ignore
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
class ParametersRepositoryTest {
    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private Database database;
    @Autowired
    private UserSizeDb userSizeDb;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private CalculateDimensionsWheelchair dimensionsWheelchair;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void saveUserSize() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        Client client2 = new Client("MMM", 1111l, 9999l, "LLLL");
        Client client3 = new Client("MMM", 2222l, 9999l, "LLLL");
        database.addUser(client1);
        database.addUser(client2);
        database.addUser(client3);
        List<Client> clientsList = database.getClients();
        assertEquals(clientsList.size(), 3);
        UserSizes userSizes = new UserSizes();
        userSizes.setClient(client1);
        userSizes.setThighLength(22);
        userSizes.setPelvisWidth(22);
        userSizes.setBackHeight(22);
        userSizes.setShinLength(22);

        userSizeDb.addUserSize(userSizes);
        List<UserSizes> userSizesList = userSizeDb.getUserSizesOrders();
        assertEquals(userSizesList.size(), 1);
        System.out.println(userSizesList.toString());

    }

    @Test
    public void getUserSizeByClientId() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        Client client2 = new Client("MMM", 1111l, 9999l, "LLLL");
        Client client3 = new Client("MMM", 2222l, 9999l, "LLLL");
        database.addUser(client1);
        database.addUser(client2);
        database.addUser(client3);

        UserSizes userSizes = new UserSizes();
        userSizes.setClient(client1);
        userSizes.setThighLength(22);
        userSizes.setPelvisWidth(22);
        userSizes.setBackHeight(22);
        userSizes.setShinLength(22);
        userSizeDb.addUserSize(userSizes);

        UserSizes userSizes2 = new UserSizes();
        userSizes2.setClient(client2);
        userSizes2.setThighLength(33);
        userSizes2.setPelvisWidth(33);
        userSizes2.setBackHeight(33);
        userSizes2.setShinLength(33);
        userSizeDb.addUserSize(userSizes2);


        UserSizes userSizes1 = userSizeDb.getUserSizeByClientId(2L);
        assertEquals(Optional.ofNullable(userSizes2.getShinLength()), Optional.of(33));
        System.out.println(userSizes1.toString());
    }

    @Test
    public void saveWheelchairDimensions() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        database.addUser(client1);
        UserSizes userSizes = new UserSizes();
        userSizes.setClient(client1);
        userSizes.setThighLength(22);
        userSizes.setPelvisWidth(22);
        userSizes.setBackHeight(22);
        userSizes.setShinLength(22);
        userSizeDb.addUserSize(userSizes);
        Wheelchair wheelchair = dimensionsWheelchair.setDimensions(22, 22, 22, 22);
        wheelchair.setClient(client1);
        wheelchairDB.addWheelchair(wheelchair);
        Wheelchair wheelchair1 = wheelchairDB.getWheelchair(1L);

        assertEquals(Optional.ofNullable(wheelchair1.getBachHeight()), Optional.of(22));
        assertEquals(Optional.ofNullable(wheelchair1.getFootrestLength()), Optional.of(40));
        assertEquals(Optional.ofNullable(wheelchair1.getSeatWidth()), Optional.of(26));
        assertEquals(Optional.ofNullable(wheelchair1.getSeatDepth()), Optional.of(24));
    }
}