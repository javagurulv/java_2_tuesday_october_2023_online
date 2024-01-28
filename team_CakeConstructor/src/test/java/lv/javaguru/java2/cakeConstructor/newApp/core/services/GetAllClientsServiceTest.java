package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllClientsResponse;
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
public class GetAllClientsServiceTest {

    @Mock
    private JpaClientRepository clientRepository;
    @InjectMocks
    private GetAllClientsService service;

    @Test
    public void shouldGetClientsFromDb() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Liza", "Muller", "31234567891"));
        Mockito.when(clientRepository.findAll()).thenReturn(clients);

        GetAllClientsRequest request = new GetAllClientsRequest();
        GetAllClientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getClients().size(), 1);
        assertEquals(response.getClients().get(0).getFirstName(), "Liza");
        assertEquals(response.getClients().get(0).getLastName(), "Muller");
        assertEquals(response.getClients().get(0).getPersonalCode(), "31234567891");
    }

}
