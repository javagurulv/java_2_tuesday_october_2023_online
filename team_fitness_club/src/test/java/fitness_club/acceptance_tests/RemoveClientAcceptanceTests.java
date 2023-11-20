package fitness_club.acceptance_tests;

import fitness_club.core.domain.FitnessCentre;
import fitness_club.dependency_injection.ApplicationContext;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.DeleteClientService;
import fitness_club.dependency_injection.DIApplicationContextBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Disabled
public class RemoveClientAcceptanceTests {
    private static ApplicationContext applicationContext =
            new DIApplicationContextBuilder().build("fitness_club");

    @Test
    public void shouldReturnError() {
        RemoveClientRequest request = new RemoveClientRequest("");
        RemoveClientResponse response = getDeleteClientService().execute(request);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Field personal code must not be empty!");
    }

    @Test
    public void shouldRemoveClient() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        getAddClientService().execute(addClientRequest);
        RemoveClientRequest request = new RemoveClientRequest("123");
        RemoveClientResponse response = getDeleteClientService().execute(request);
        assertTrue(response.isClientRemoved());
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private DeleteClientService getDeleteClientService() {
        return applicationContext.getBean(DeleteClientService.class);
    }
}
