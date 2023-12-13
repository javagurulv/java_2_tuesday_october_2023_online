package fitness_club.core.services;

import fitness_club.core.database.Database;
import fitness_club.core.responses.RemoveClientResponse;
import fitness_club.core.requests.RemoveClientRequest;
import fitness_club.core.services.data_vlidation.RemoveClientRequestValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class RemoveClientServiceTest {
    @Mock
    private Database database;
    @Mock
    private RemoveClientRequestValidator validator;
    @InjectMocks
    private DeleteClientService service;


    @Test
    public void shouldDeleteClientWithPersonaCodeFromDatabase() {
        RemoveClientRequest request = new RemoveClientRequest("12-12");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.deleteByPersonalCode("12-12")).thenReturn(true);
        RemoveClientResponse response = service.execute(request);
        Assert.assertFalse(response.hasErrors());
        Assert.assertTrue(response.isClientRemoved());
    }
}
