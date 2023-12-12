package fitness_club.acceptance_tests;

import fitness_club.DatabaseCleaner;
import fitness_club.config.WorkoutsConfiguration;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.GetAllClientsService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WorkoutsConfiguration.class)
@Sql({"/schema.sql"})
public class GetAllClientsTest {

    @Autowired
    private AddClientService addClientService;
    @Autowired
    private GetAllClientsService getAllClientsService;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnCorrectClientAmount() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123");
        addClientService.execute(addClientRequest);

        AddClientRequest addClientRequest2 = new AddClientRequest("FirstName", "LastName", "321");
        addClientService.execute(addClientRequest2);

        GetAllClientsResponse response = getAllClientsService.execute(new GetAllClientsRequest());
        assertEquals(response.getClients().size(), 2);
    }
}
