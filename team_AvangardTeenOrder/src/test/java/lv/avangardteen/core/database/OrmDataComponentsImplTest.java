package lv.avangardteen.core.database;

import lv.avangardteen.DatabaseCleaner;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.service.UserRegistrationService;
import lv.avangardteen.core.service.validate.PersonalDateValidation;
import org.junit.Before;
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
@ContextConfiguration(classes = {Database.class})
@Sql({"/schema.sql"})
class OrmDataComponentsImplTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private PersonalDateValidation validation;
    @Autowired
    private UserRegistrationService service;
    @Autowired
    private Database database;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

 /*   @Test
    public void wheelFrontChooseIsAbsent() {
        dataComponents.addComponent(new Components("FRONT_WHEEL", "MH01", "INFORMATION", 1.1));
        dataComponents.addComponent(new Components("BACK_WHEEL", "MN01", "INFORMATION1", 2.2));
        dataComponents.addComponent(new Components("BRAKE", "MF01", "INFORMATION2", 3.3));
        dataComponents.addComponent(new Components("FOOTREST", "MK01", "INFORMATION3", 4.4));


        Components components = dataComponents.getComponent(1);
        assertEquals(1, components.getId());

    }*/

    @Test
    public void wheelFrontChooseIsAbsent() {
      //Client client = new Client("MMM", 9999l, 9999l, "LLLL");
        UserRegistrationRequest request = new UserRegistrationRequest("MMM", 9999l, 9999l, "LLLL");
      service.execute(request);


       Client client = database.getClientById(1l);
        assertEquals("MMM", client.getNameSurname());

    }
}