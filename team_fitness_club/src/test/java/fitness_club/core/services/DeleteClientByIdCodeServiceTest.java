package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.requests.DeleteClientByIdRequest;
import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.DeleteClientByIdResponse;
import fitness_club.core.responses.DeleteClientByPersonalCodeResponse;
import fitness_club.core.services.validators.client.DeleteClientByIdRequestValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class DeleteClientByIdCodeServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private DeleteClientByIdRequestValidator validator;
    @InjectMocks
    private  DeleteClientByIdService service;


    @Test
    public void shouldDeleteClientWithIdFromDatabase() {
        DeleteClientByIdRequest request = new DeleteClientByIdRequest(1L);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(clientRepository.deleteById(1L)).thenReturn(true);
        DeleteClientByIdResponse response = service.executeByClientId(request);
        Assert.assertFalse(response.hasErrors());
        Assert.assertTrue(response.isClientRemoved());
    }
}
