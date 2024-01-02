package lv.avangardteen.core.database;

import lv.avangardteen.config.OrderListConfiguration;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrderListConfiguration.class})
@Sql({"/schema.sql"})
class OrmClientRepositoryTest {

    @Autowired
    Database database;

    @Test
    public void injectedRepositoryAreNotNull() {
        assertNotNull(database);
    }



}