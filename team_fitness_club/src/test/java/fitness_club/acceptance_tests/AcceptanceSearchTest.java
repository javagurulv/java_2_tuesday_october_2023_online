package fitness_club.acceptance_tests;

import fitness_club.core.DatabaseCleaner;
import fitness_club.config.SpringCoreConfiguration;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.SearchClientService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
public class AcceptanceSearchTest {
    @Autowired private AddClientService addClientService;
    @Autowired private SearchClientService searchClientService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }



    @Test
    public void searchClients() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        addClientService.execute(request1);

        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        addClientService.execute(request2);

        SearchClientRequest request3 = new SearchClientRequest("Aaa", null);
        SearchClientResponse response = searchClientService.execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bbb");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Ddd");
    }

    @Test
    public void searchBooksOrderingDescending() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        addClientService.execute(request1);

        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        addClientService.execute(request2);

        Ordering ordering = new Ordering("lastName", "DESCENDING");
        SearchClientRequest request3 = new SearchClientRequest("Aaa", null, ordering);
        SearchClientResponse response = searchClientService.execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Ddd");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Bbb");
    }

    @Test
    public void searchBooksOrderingAscending() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        addClientService.execute(request1);

        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        addClientService.execute(request2);

        Ordering ordering = new Ordering("lastName", "ASCENDING");

        SearchClientRequest request3 = new SearchClientRequest("Aaa", null, ordering);
        SearchClientResponse response = searchClientService.execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bbb");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Ddd");
    }

    @Test
    public void searchBooksOrderingPaging() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        addClientService.execute(request1);

        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        addClientService.execute(request2);

        Ordering ordering = new Ordering("lastName", "ASCENDING");

        Paging paging = new Paging(1,2);

        SearchClientRequest request3 = new SearchClientRequest("Aaa", null, ordering, paging);
        SearchClientResponse response = searchClientService.execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bbb");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Ddd");
    }
}
