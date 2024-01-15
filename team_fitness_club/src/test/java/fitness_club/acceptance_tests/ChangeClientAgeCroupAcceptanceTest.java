package fitness_club.acceptance_tests;

import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

@Ignore
public class ChangeClientAgeCroupAcceptanceTest {
    /*private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(ClientWorkoutsConfiguration.class);
    }


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

     */
}
