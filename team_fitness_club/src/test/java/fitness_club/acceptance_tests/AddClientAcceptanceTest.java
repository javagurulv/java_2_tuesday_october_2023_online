package fitness_club.acceptance_tests;

import fitness_club.DatabaseCleaner;
import fitness_club.config.SpringCoreConfiguration;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.SearchClientService;
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
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
public class AddClientAcceptanceTest {
    @Autowired
    private AddClientService addClientService;
    @Autowired private SearchClientService searchClientService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }


    @Test
    public void shouldReturnErrorForFirstName() {
        AddClientRequest addClientRequest = new AddClientRequest("", "test", "12345");
        AddClientResponse response = addClientService.execute(addClientRequest);
        assertEquals(response.getErrors().get(0).getField(), "firstName");
        assertEquals(response.getErrors().get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorForLastName() {
        AddClientRequest addClientRequest = new AddClientRequest("test", "", "12345");
        AddClientResponse response = addClientService.execute(addClientRequest);
        assertEquals(response.getErrors().get(0).getField(), "lastName");
        assertEquals(response.getErrors().get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorForPersonalCode() {
        AddClientRequest addClientRequest = new AddClientRequest("test", "test2", "");
        AddClientResponse response = addClientService.execute(addClientRequest);
        assertEquals(response.getErrors().size(), 2);
        assertEquals(response.getErrors().get(1).getField(), "personalCode");
        assertEquals(response.getErrors().get(1).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    public void shouldReturnCorrectClient() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123");
        addClientService.execute(addClientRequest);
        SearchClientResponse response = searchClientService.execute(new SearchClientRequest("FirstName", "LastName"));
        assertEquals(response.getFoundClients().get(0).getFirstName(), "FirstName");
        assertEquals(response.getFoundClients().get(0).getLastName(), "LastName");
        assertEquals(response.getFoundClients().get(0).getPersonalCode(), "123");
      //  assertEquals(response.getFoundClients().get(0).getClientAgeGroup(), ClientAgeGroups.ADULT);
      //  assertEquals(response.getFoundClients().get(0).getWorkouts(), Workouts.GYM);
    }


}
