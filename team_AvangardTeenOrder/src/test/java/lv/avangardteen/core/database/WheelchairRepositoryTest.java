package lv.avangardteen.core.database;

import lv.avangardteen.core.DatabaseCleaner;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.Wheelchair;
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
class WheelchairRepositoryTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private Database database;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void wheelchairTest() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        Client client2 = new Client("MMM", 1111l, 9999l, "LLLL");
        Client client3 = new Client("MMM", 2222l, 9999l, "LLLL");
        database.addUser(client1);
        database.addUser(client2);
        database.addUser(client3);

        Wheelchair wheelchair = new Wheelchair();
        wheelchair.setClient(client1);
        wheelchair.setPrice(177000.0);
        wheelchair.setBachHeight(22);
        wheelchair.setFootrestLength(22);
        wheelchair.setSeatDepth(22);
        wheelchair.setSeatWidth(22);
        wheelchairDB.addWheelchair(wheelchair);

        List<Wheelchair> wheelchairList = wheelchairDB.getWheelchairsList();
        assertEquals(wheelchairList.size(), 1);

        Wheelchair wheelchair1 = wheelchairDB.getWheelchair(1L);
        System.out.println(wheelchair1.toString());

        Double prise = wheelchairDB.getPrice(1L);
        assertEquals(prise, 177000.0);

    }

    @Test
    public void deleteWheelchair() {
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
        Wheelchair wheelchair1 = wheelchairDB.getWheelchair(1L);
        System.out.println(wheelchair1.toString());

        Boolean deleteWheelchair = wheelchairDB.deleteWheelchairById(1L);
        assertTrue(deleteWheelchair);

    }
}