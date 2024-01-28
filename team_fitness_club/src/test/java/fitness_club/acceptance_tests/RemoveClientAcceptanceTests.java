package fitness_club.acceptance_tests;

import fitness_club.config.SpringCoreConfiguration;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.RemoveClientByIdResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.RemoveClientByPersonalCodeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;


public class RemoveClientAcceptanceTests {
    private ApplicationContext applicationContext;

    @Before
    public void setup() {
        applicationContext = new AnnotationConfigApplicationContext(SpringCoreConfiguration.class);
    }

    @Test
    public void shouldReturnError() {
        RemoveClientByPersonalCodeRequest request = new RemoveClientByPersonalCodeRequest(null);
        RemoveClientByIdResponse response =getDeleteClientService().execute(request);
        assertEquals(response.getErrors().get(0).getField(), "PersonalCode");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveClient() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123");
        getAddClientService().execute(addClientRequest);
        RemoveClientByPersonalCodeRequest request = new RemoveClientByPersonalCodeRequest("123");
        RemoveClientByIdResponse response = getDeleteClientService().execute(request);
        assertFalse(response.hasErrors());
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private RemoveClientByPersonalCodeService getDeleteClientService() {
        return applicationContext.getBean(RemoveClientByPersonalCodeService.class);
    }
}
