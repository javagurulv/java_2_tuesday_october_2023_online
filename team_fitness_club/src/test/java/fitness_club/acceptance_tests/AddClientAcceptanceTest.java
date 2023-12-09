package fitness_club.acceptance_tests;

import fitness_club.DatabaseCleaner;
import fitness_club.config.ClientWorkoutsConfiguration;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.SearchClientService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

@Ignore
public class AddClientAcceptanceTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(ClientWorkoutsConfiguration.class);
        getDatabaseCleaner().clean();
    }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }



    @Test
    public void shouldReturnErrorForFirstName() {
        AddClientRequest addClientRequest = new AddClientRequest("", "test", "12345", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        AddClientResponse response = getAddClientService().execute(addClientRequest);
        assertEquals(response.getErrors().get(0).getField(), "firstName");
        assertEquals(response.getErrors().get(0).getMessage(), "Field first name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorForLastName() {
        AddClientRequest addClientRequest = new AddClientRequest("test", "", "12345", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        AddClientResponse response = getAddClientService().execute(addClientRequest);
        assertEquals(response.getErrors().get(0).getField(), "lastName");
        assertEquals(response.getErrors().get(0).getMessage(), "Field last name must not be empty or contain symbols or numbers!");
    }

    @Test
    public void shouldReturnErrorForPersonalCode() {
        AddClientRequest addClientRequest = new AddClientRequest("test", "test2", "", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        AddClientResponse response = getAddClientService().execute(addClientRequest);
        assertEquals(response.getErrors().size(), 2);
        assertEquals(response.getErrors().get(1).getField(), "personalCode");
        assertEquals(response.getErrors().get(1).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    public void shouldReturnCorrectClient() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        getAddClientService().execute(addClientRequest);
        SearchClientResponse response = getSearchClientService().execute(new SearchClientRequest("FirstName", "LastName"));
        assertEquals(response.getFoundClients().get(0).getFirstName(), "FirstName");
        assertEquals(response.getFoundClients().get(0).getLastName(), "LastName");
        assertEquals(response.getFoundClients().get(0).getPersonalCode(), "123");
        assertEquals(response.getFoundClients().get(0).getClientAgeGroup(), ClientAgeGroups.ADULT);
        assertEquals(response.getFoundClients().get(0).getWorkouts(), Workouts.GYM);
    }

    private SearchClientService getSearchClientService() {
        return applicationContext.getBean(SearchClientService.class);
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }
}
