package fitness_club.acceptance_tests;

import fitness_club.ApplicationContext;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.SearchClientService;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceSearchTest {
    ApplicationContext appContext = new ApplicationContext();

    @Test
    void searchClients() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123", ClientAgeGroups.ADULT, Workouts.GYM);
        getAddclientService().execute(request1);

        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234", ClientAgeGroups.ADULT, Workouts.GYM);
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
    void searchBooksOrderingDescending() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123", ClientAgeGroups.ADULT, Workouts.GYM);
        getAddclientService().execute(request1);
        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234", ClientAgeGroups.ADULT, Workouts.GYM);
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
    void searchBooksOrderingAscending() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123", ClientAgeGroups.ADULT, Workouts.GYM);
        getAddclientService().execute(request1);
        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234", ClientAgeGroups.ADULT, Workouts.GYM);
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
    void searchBooksOrderingPaging() {
        AddClientRequest request1 = new AddClientRequest("Aaa", "Bbb", "123", ClientAgeGroups.ADULT, Workouts.GYM);
        getAddclientService().execute(request1);
        AddClientRequest request2 = new AddClientRequest("Aaa", "Ddd", "1234", ClientAgeGroups.ADULT, Workouts.GYM);
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
        return appContext.getBean(AddClientService.class);
    }

    private SearchClientService getSearchClientService() {
        return appContext.getBean(SearchClientService.class);
    }
}
