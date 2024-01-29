package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchClientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.ClientRepository;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.SearchClientsRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class SearchClientsServiceTest {

    @Mock private JpaClientRepository clientRepository;
    @Mock private SearchClientsRequestValidator validator;
    @InjectMocks
    private SearchClientsService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchClientsRequest request = new SearchClientsRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("firstName", "Must not be empty!"));
        errors.add(new CoreError("lastName", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchClientsResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(clientRepository);
    }

    @Test
    public void shouldSearchByFirstName() {
        SearchClientsRequest request = new SearchClientsRequest("Liza", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Liza", "Muller", "31234567891"));
        Mockito.when(clientRepository.findByFirstNameLike("Liza")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByLastName() {
        SearchClientsRequest request = new SearchClientsRequest(null, "Muller");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client( "Liza", "Muller", "31234567891"));
        Mockito.when(clientRepository.findByLastNameLike("Muller")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameAndLastName() {
        SearchClientsRequest request = new SearchClientsRequest("Liza", "Muller");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Liza", "Muller", "31234567891"));
        Mockito.when(clientRepository.findByFirstNameAndLastNameLike("Liza", "Muller")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithOrderingAscending() {
        Ordering ordering = new Ordering("lastName", "ASCENDING");
        SearchClientsRequest request = new SearchClientsRequest("Liza", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client( "Liza", "Muller2", "31234567891"));
        clients.add(new Client("Liza", "Muller1", "31234567891"));
        Mockito.when(clientRepository.findByFirstNameLike("Liza")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 2);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller1");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(1).getLastName(), "Muller2");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithOrderingDescending() {
        Ordering ordering = new Ordering("lastName", "DESCENDING");
        SearchClientsRequest request = new SearchClientsRequest("Liza", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Liza", "Muller1", "31234567891"));
        clients.add(new Client( "Liza", "Muller2", "31234567891"));
        Mockito.when(clientRepository.findByFirstNameLike("Liza")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 2);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller2");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(1).getLastName(), "Muller1");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchClientsRequest request = new SearchClientsRequest("Liza", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Liza", "Muller1", "31234567891"));
        clients.add(new Client( "Liza", "Muller2", "31234567891"));
        Mockito.when(clientRepository.findByFirstNameLike("Liza")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller1");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

    @Test
    public void shouldSearchByFirstNameWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchClientsRequest request = new SearchClientsRequest("Liza", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Liza", "Muller1", "31234567891"));
        clients.add(new Client("Liza", "Muller2", "31234567891"));
        Mockito.when(clientRepository.findByFirstNameLike("Liza")).thenReturn(clients);

        SearchClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller2");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

}