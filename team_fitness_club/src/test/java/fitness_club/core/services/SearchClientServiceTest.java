package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.data_vlidation.SearchClientRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(MockitoJUnitRunner.class)
public class SearchClientServiceTest {
   /* @Mock
    private Database database;
    @Mock
    private SearchClientRequestValidator validator;
    @InjectMocks
    private SearchClientService service;

    @Test
    public void shouldSearchByFirstName() {

        SearchClientRequest request = new SearchClientRequest("Dmitry", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Ivan", "Petrov", "1234"));
        Mockito.when(database.findByFirstName("Ivan")).thenReturn(clients);

        SearchClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getFoundClients().size(), 1);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Ivan");
        assertEquals(response.getFoundClients().get(0).getLastName(),"Petrov");
    }
    @Test
    public void shouldSearchByLastName() {

        SearchClientRequest request = new SearchClientRequest(null, "Petrov");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Ivan", "Petrov", "1234"));
        Mockito.when(database.findByLastName("Petrov")).thenReturn(clients);

        SearchClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getFoundClients().size(), 1);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Ivan");
        assertEquals(response.getFoundClients().get(0).getLastName(),"Petrov");
    }
    @Test
    public void shouldSearchByFirstNameWithOrderingAscending() {
        Ordering ordering = new Ordering("lastName", "ASCENDING");
        SearchClientRequest request = new SearchClientRequest("firstName", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Dmitry", "Arbuzov", "111"));
        clients.add(new Client("Dmitry","Bananov", "112"));
        Mockito.when(database.findByFirstName("Dmitry")).thenReturn(clients);

        SearchClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getLastName(), "Arbuzov");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Bananov");
    }

    @Test
    public void shouldSearchByFirstNameWithOrderingDescending() {
        Ordering ordering = new Ordering("lastName", "DESCENDING");
        SearchClientRequest request = new SearchClientRequest("firstName", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Dmitry", "Arbuzov", "111"));
        clients.add(new Client("Dmitry","Bananov", "112"));
        Mockito.when(database.findByFirstName("firstName")).thenReturn(clients);

        SearchClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bananov");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Arbuzov");
    }
    @Test
    public void shouldSearchByTitleWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchClientRequest request = new SearchClientRequest("Dmitry", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Dmitry", "Arbuzov", "111"));
        clients.add(new Client("Dmitry","Bananov", "112"));
        Mockito.when(database.findByFirstName("Dimitry")).thenReturn(clients);

        SearchClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getFoundClients().size(), 1);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Dmitry");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Arbuzov");
    }

    @Test
    public void shouldSearchByTitleWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchClientRequest request = new SearchClientRequest("Dmitry", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Dmitry", "Arbuzov", "111"));
        clients.add(new Client("Dmitry","Bananov", "112"));
        Mockito.when(database.findByFirstName("Dmitry")).thenReturn(clients);

        SearchClientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getFoundClients().size(), 1);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Dmitry");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bananov");
    }

    */

}