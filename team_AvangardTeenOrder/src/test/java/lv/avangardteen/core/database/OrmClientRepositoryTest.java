package lv.avangardteen.core.database;

import lv.avangardteen.core.DatabaseCleaner;
import lv.avangardteen.config.SpringCoreConfiguration;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.request.UserRegistrationRequest;
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
import static org.junit.Assert.assertEquals;


@Ignore
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
class OrmClientRepositoryTest {

    @Autowired
    private DatabaseCleaner databaseCleaner;
    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private Database database;


    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void getClientById() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        UserRegistrationRequest request = new UserRegistrationRequest("MMM", 9999l, 9999l, "LLLL");
        userRegistrationService.execute(request);
        Client client = database.getClientById(1L);

        assertEquals(client1.getNameSurname(), client.getNameSurname());


    }

    @Test
    public void getListClients() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        Client client2 = new Client("MMM", 1111l, 9999l, "LLLL");
        Client client3 = new Client("MMM", 2222l, 9999l, "LLLL");
        database.addUser(client1);
        database.addUser(client2);
        database.addUser(client3);
        List<Client> clientsList = database.getClients();
        assertEquals(clientsList.size(), 3);


    }

    @Test
    public void getClientsList() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        Client client2 = new Client("MMM", 1111l, 9999l, "LLLL");
        Client client3 = new Client("MMM", 2222l, 9999l, "LLLL");
        database.addUser(client1);
        database.addUser(client2);
        database.addUser(client3);
        System.out.println(client1.getId());
        System.out.println(client2.getId());
        System.out.println(client3.getId());
        List<Client> clientsList = database.getClients();
        Client client = database.getClientById(3L);
       assertEquals(clientsList.size(), 3);
        assertEquals(client3.getPersonalCode(), client.getPersonalCode());


    }

    @Test
    public void getClientByNameAndSurname() {
        Client client1 = new Client("MMM", 9999l, 9999l, "LLLL");
        Client client2 = new Client("MMM", 1111l, 9999l, "LLLL");
        Client client3 = new Client("MMM", 2222l, 9999l, "LLLL");
        database.addUser(client1);
        database.addUser(client2);
        database.addUser(client3);
        Client client = database.findBySurnameAndPersonalCode("MMM", 1111l);

        assertEquals(client3.getPhone(), client.getPhone());


    }

}
