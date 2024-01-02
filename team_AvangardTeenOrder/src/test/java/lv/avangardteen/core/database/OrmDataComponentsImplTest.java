package lv.avangardteen.core.database;

import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.OrderApplication;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {OrderApplication.class})
@Sql({"/schema.sql"})
class OrmDataComponentsImplTest {

    @Autowired
    private OrmDataComponentsImpl ormDataComponents;
    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void injectedRepositoryAreNotNull() {
        assertNotNull(ormDataComponents);
    }

}