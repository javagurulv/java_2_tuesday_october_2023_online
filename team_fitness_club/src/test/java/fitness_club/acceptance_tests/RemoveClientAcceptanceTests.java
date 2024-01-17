package fitness_club.acceptance_tests;

import fitness_club.config.SpringCoreConfiguration;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.DeleteClientByPersonalCodeResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.DeleteClientByPersonalCodeService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
public class RemoveClientAcceptanceTests {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
    }

    @Test
    public void shouldReturnError() {
        DeleteClientByPersonalCodeRequest request = new DeleteClientByPersonalCodeRequest("");
        DeleteClientByPersonalCodeResponse response = getDeleteClientService().executeByPersonalCode(request);
        assertEquals(response.getErrors().get(0).getField(), "personalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveClient() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123");
        getAddClientService().execute(addClientRequest);
        DeleteClientByPersonalCodeRequest request = new DeleteClientByPersonalCodeRequest("123");
        DeleteClientByPersonalCodeResponse response = getDeleteClientService().executeByPersonalCode(request);
        assertTrue(response.isClientRemoved());
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private DeleteClientByPersonalCodeService getDeleteClientService() {
        return applicationContext.getBean(DeleteClientByPersonalCodeService.class);
    }
}
