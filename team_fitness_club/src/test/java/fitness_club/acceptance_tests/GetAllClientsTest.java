package fitness_club.acceptance_tests;

import fitness_club.ApplicationContext;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.GetAllClientsService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class GetAllClientsTest {
    private ApplicationContext appContext = new ApplicationContext();

    @Test
    public void shouldReturnCorrectClientAmount() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123", ClientAgeGroups.ADULT, Workouts.GYM);
        AddClientRequest addClientRequest2 = new AddClientRequest("FirstName", "LastName", "321", ClientAgeGroups.ADULT, Workouts.GYM);
        getAddClientService().execute(addClientRequest);
        getAddClientService().execute(addClientRequest2);
        GetAllClientsResponse response = getGetAllClientsService().execute(new GetAllClientsRequest());
        assertEquals(response.getClients().size(), 2);
    }

    private AddClientService getAddClientService() {
        return appContext.getBean(AddClientService.class);
    }

    private GetAllClientsService getGetAllClientsService() {
        return appContext.getBean(GetAllClientsService.class);
    }
}
