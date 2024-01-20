package fitness_club.acceptance_tests;

import fitness_club.config.SpringCoreConfiguration;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.RemoveClientByIdRequest;
import fitness_club.core.responses.RemoveClientByIdResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.RemoveClientByIdService;
import org.junit.Before;
import org.junit.Ignore;
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
        RemoveClientByIdRequest request = new RemoveClientByIdRequest(null);
        RemoveClientByIdResponse response =getDeleteClientService().execute(request);
        assertEquals(response.getErrors().get(0).getField(), "Id");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveClient() {
        AddClientRequest addClientRequest = new AddClientRequest("FirstName", "LastName", "123");
        getAddClientService().execute(addClientRequest);
        RemoveClientByIdRequest request = new RemoveClientByIdRequest(1L);
        RemoveClientByIdResponse response = getDeleteClientService().execute(request);
        assertFalse(response.hasErrors());
    }

    private AddClientService getAddClientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private RemoveClientByIdService getDeleteClientService() {
        return applicationContext.getBean(RemoveClientByIdService.class);
    }
}
