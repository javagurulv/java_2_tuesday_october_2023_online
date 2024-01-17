package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.requests.DeleteClientByIdRequest;
import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.DeleteClientByPersonalCodeResponse;
import fitness_club.core.services.validators.client.DeleteClientByPersonalCodeRequestValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class DeleteClientByPersonalCodeServiceTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private DeleteClientByPersonalCodeRequestValidator validator;
    @InjectMocks
    private DeleteClientByPersonalCodeService service;


    @Test
    public void shouldDeleteClientWithPersonaCodeFromDatabase() {
        DeleteClientByPersonalCodeRequest request = new DeleteClientByPersonalCodeRequest("12-12");
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(clientRepository.deleteByPersonalCode("12-12")).thenReturn(true);
        DeleteClientByPersonalCodeResponse response = service.executeByPersonalCode(request);
        Assert.assertFalse(response.hasErrors());
        Assert.assertTrue(response.isClientRemoved());
    }
   }
