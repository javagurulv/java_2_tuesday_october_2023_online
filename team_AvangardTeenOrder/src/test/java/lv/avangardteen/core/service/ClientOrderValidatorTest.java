package lv.avangardteen.core.service;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientOrderValidatorTest {

    ClientOrderValidator validator = new ClientOrderValidator();
@Test
    void nameSurnameIsNull() {
        ClientRequest request = mock(ClientRequest.class);
        {
            when(request.getNameSurname()).thenReturn(null);
            when(request.getPhoneNumber()).thenReturn(2344510);
            when(request.getUserAddress()).thenReturn("Adress");
            when(request.getPelvisWidth()).thenReturn(11);
            when(request.getThighLength()).thenReturn(22);
            when(request.getBackLength()).thenReturn(33);
            when(request.getShinLength()).thenReturn(25);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "nameSurname");
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");

        }
    }
    @Test
    void whenUserAdressEmpty() {
        ClientRequest request = mock(ClientRequest.class);
        {
            when(request.getNameSurname()).thenReturn("TestName");
            when(request.getPhoneNumber()).thenReturn(2344510);
            when(request.getUserAddress()).thenReturn("");
            when(request.getPelvisWidth()).thenReturn(11);
            when(request.getThighLength()).thenReturn(22);
            when(request.getBackLength()).thenReturn(33);
            when(request.getShinLength()).thenReturn(25);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "userAddress");
            assertEquals(errors.get(0).getMessage(), "Must not be empty");
        }
    }

    @Test
    void whenPelvisWidthNull() {
        ClientRequest request = mock(ClientRequest.class);
        {
            when(request.getNameSurname()).thenReturn("TestName");
            when(request.getPhoneNumber()).thenReturn(109876);
            when(request.getUserAddress()).thenReturn("Test Address");
            when(request.getPelvisWidth()).thenReturn(0);
            when(request.getThighLength()).thenReturn(22);
            when(request.getBackLength()).thenReturn(33);
            when(request.getShinLength()).thenReturn(25);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "pelvisWidth");
            assertEquals(errors.get(0).getMessage(), "Must not be empty");
        }
    }

    @Test
    void whenThighLengthNull() {
        ClientRequest request = mock(ClientRequest.class);
        {
            when(request.getNameSurname()).thenReturn("TestName");
            when(request.getPhoneNumber()).thenReturn(103245);
            when(request.getUserAddress()).thenReturn("Test Address");
            when(request.getPelvisWidth()).thenReturn(11);
            when(request.getThighLength()).thenReturn(0);
            when(request.getBackLength()).thenReturn(33);
            when(request.getShinLength()).thenReturn(25);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "thighLength");
            assertEquals(errors.get(0).getMessage(), "Must not be empty");
        }
    }

    @Test
    void whenBackLengthNull() {
        ClientRequest request = mock(ClientRequest.class);
        {
            when(request.getNameSurname()).thenReturn("TestName");
            when(request.getPhoneNumber()).thenReturn(13132452);
            when(request.getUserAddress()).thenReturn("Test Address");
            when(request.getPelvisWidth()).thenReturn(11);
            when(request.getThighLength()).thenReturn(22);
            when(request.getBackLength()).thenReturn(0);
            when(request.getShinLength()).thenReturn(25);
            List<CoreError> errors = validator.validate(request);
            assertFalse(errors.isEmpty());
            assertEquals(errors.size(), 1);
            assertEquals(errors.get(0).getField(), "backHeight");
            assertEquals(errors.get(0).getMessage(), "Must not be empty");
        }
    }
}