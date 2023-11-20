package fitness_club.acceptance_tests;

import fitness_club.core.domain.FitnessCentre;
import fitness_club.dependency_injection.ApplicationContext;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.ChangeClientAgeGroupService;
import fitness_club.core.services.SearchClientService;
import fitness_club.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@Disabled
public class ChangeClientAgeCroupTest {
    private static ApplicationContext applicationContext =
            new DIApplicationContextBuilder().build("fitness_club");

    @Test
    public void shouldChangeClientAgeGroup() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "12345", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        getAddClientService().execute(addClientRequest);
        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest("12345", ClientAgeGroups.CHILD);
        getChangeClientAgeGroupService().execute(request);
        SearchClientResponse response = getSearchClientService().execute(new SearchClientRequest("FirstName", "LastName"));
        assertEquals(response.getFoundClients().get(0).getClientAgeGroup(), ClientAgeGroups.CHILD);
    }

    @Test
    public void shouldReturnError() {
        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest("", ClientAgeGroups.CHILD);
        ChangeClientAgeGroupResponse response = getChangeClientAgeGroupService().execute(request);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Field personal code must not be empty!");
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private ChangeClientAgeGroupService getChangeClientAgeGroupService() {
        return applicationContext.getBean(ChangeClientAgeGroupService.class);
    }

    private SearchClientService getSearchClientService() {
        return applicationContext.getBean(SearchClientService.class);
    }
}
