package fitness_club.acceptance_tests;

import fitness_club.config.SpringCoreConfiguration;
import org.junit.Before;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

@Ignore
public class ChangeWorkoutsTest {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
    }


   /* @Test
    public void shouldChangeClientAgeGroup() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "12345", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
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
        return applicationContext.getBean(AddClientService.class);
    }

    private ChangeClientWorkoutService getChangeClientWorkoutService() {
        return applicationContext.getBean(ChangeClientWorkoutService.class);
    }

    private SearchClientService getSearchClientService() {
        return applicationContext.getBean(SearchClientService.class);
    }

    */
}
