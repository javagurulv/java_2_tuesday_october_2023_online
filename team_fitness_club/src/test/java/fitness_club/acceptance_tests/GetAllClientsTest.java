package fitness_club.acceptance_tests;

import fitness_club.config.ClientWorkoutsConfiguration;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.GetAllClientsService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

@Ignore
public class GetAllClientsTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(ClientWorkoutsConfiguration.class);
    }

    @Test
    public void shouldReturnCorrectClientAmount() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        AddClientRequest addClientRequest2 = new AddClientRequest("FirstName", "LastName", "321", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        getAddClientService().execute(addClientRequest);
        getAddClientService().execute(addClientRequest2);
        GetAllClientsResponse response = getGetAllClientsService().execute(new GetAllClientsRequest());
        assertEquals(response.getClients().size(), 2);
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private GetAllClientsService getGetAllClientsService() {
        return applicationContext.getBean(GetAllClientsService.class);
    }
}
