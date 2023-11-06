package fitness_club.acceptance_tests;

import fitness_club.ApplicationContext;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.ChangeClientWorkoutsResponse;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.ChangeClientWorkoutService;
import fitness_club.core.services.SearchClientService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ChangeWorkoutsTest {
    private ApplicationContext appContext = new ApplicationContext();

    @Test
    public void shouldChangeClientAgeGroup() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "12345", ClientAgeGroups.ADULT, Workouts.GYM);
        getAddClientService().execute(addClientRequest);
        ChangeClientWorkoutsRequest request = new ChangeClientWorkoutsRequest("12345", Workouts.GROUP_CLASSES);
        getChangeClientWorkoutService().execute(request);
        SearchClientResponse response = getSearchClientService().execute(new SearchClientRequest("FirstName", "LastName"));
        assertEquals(response.getFoundClients().get(0).getWorkouts(), Workouts.GROUP_CLASSES);
    }

    @Test
    public void shouldReturnError() {
        ChangeClientWorkoutsRequest request = new ChangeClientWorkoutsRequest("", Workouts.GYM);
        ChangeClientWorkoutsResponse response = getChangeClientWorkoutService().execute(request);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Field personal code must not be empty!");
    }

    private AddClientService getAddClientService() {
        return appContext.getBean(AddClientService.class);
    }

    private ChangeClientWorkoutService getChangeClientWorkoutService() {
        return appContext.getBean(ChangeClientWorkoutService.class);
    }

    private SearchClientService getSearchClientService() {
        return appContext.getBean(SearchClientService.class);
    }
}
