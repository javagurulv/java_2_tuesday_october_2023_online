package fitness_club.acceptance_tests;

import fitness_club.DatabaseCleaner;
import fitness_club.config.ClientWorkoutsConfiguration;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

@Ignore
public class AcceptanceSearchTest {
   private ApplicationContext applicationContext;

   @Before
   public void setup() {
       applicationContext = new AnnotationConfigApplicationContext(ClientWorkoutsConfiguration.class);
       getDatabaseCleaner().clean();
   }

    private DatabaseCleaner getDatabaseCleaner() {
        return applicationContext.getBean(DatabaseCleaner.class);
    }


    @Test
    public void searchClients() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        getAddclientService().execute(request1);

        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        getAddclientService().execute(request2);
        SearchClientRequest request3 = new SearchClientRequest("Aaa", null);
        SearchClientResponse response = getSearchClientService().execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bbb");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Ddd");
    }

    @Test
    public void searchBooksOrderingDescending() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        getAddclientService().execute(request1);
        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        getAddclientService().execute(request2);

        Ordering ordering = new Ordering("lastName", "DESCENDING");
        SearchClientRequest request3 = new SearchClientRequest("Aaa", null, ordering);
        SearchClientResponse response = getSearchClientService().execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Ddd");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Bbb");
    }

    @Test
    public void searchBooksOrderingAscending() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        getAddclientService().execute(request1);
        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        getAddclientService().execute(request2);

        Ordering ordering = new Ordering("lastName", "ASCENDING");

        SearchClientRequest request3 = new SearchClientRequest("Aaa", null, ordering);
        SearchClientResponse response = getSearchClientService().execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bbb");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Ddd");
    }

    @Test
    public void searchBooksOrderingPaging() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123");
        getAddclientService().execute(request1);
        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234");
        getAddclientService().execute(request2);

        Ordering ordering = new Ordering("lastName", "ASCENDING");

        Paging paging = new Paging(1,2);

        SearchClientRequest request3 = new SearchClientRequest("Aaa", null, ordering, paging);
        SearchClientResponse response = getSearchClientService().execute(request3);

        assertEquals(response.getFoundClients().size(), 2);
        assertEquals(response.getFoundClients().get(0).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(0).getLastName(), "Bbb");
        assertEquals(response.getFoundClients().get(1).getFirstName(), "Aaa");
        assertEquals(response.getFoundClients().get(1).getLastName(), "Ddd");
    }

    private AddClientService getAddclientService() {
        return applicationContext.getBean(AddClientService.class);
    }

    private SearchClientService getSearchClientService() {
        return applicationContext.getBean(SearchClientService.class);
    }
}
