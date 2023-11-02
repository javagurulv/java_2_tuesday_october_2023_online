package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientOrderValidatorTest {

    private ClientOrderValidator validator;

    @Test
    void nameSurnameIsNull() {
        Database database = Mockito.mock(Database.class);
        ClientRequest request = Mockito.mock(ClientRequest.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ClientOrderValidator(null, dataComponents);
        when(request.getNameSurname()).thenReturn(null);
        when(request.getPhoneNumber()).thenReturn(2344510);
        when(request.getUserAddress()).thenReturn("Address");
        when(request.getPelvisWidth()).thenReturn(11);
        when(request.getThighLength()).thenReturn(22);
        when(request.getBackLength()).thenReturn(33);
        when(request.getShinLength()).thenReturn(25);
        when(request.getIndexWheelFront()).thenReturn(11);
        when(request.getIndexWheelBack()).thenReturn(21);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "nameSurname");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");


    }

    @Test
    void whenUserAddressEmpty() {
        Database database = Mockito.mock(Database.class);
        ClientRequest request = Mockito.mock(ClientRequest.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ClientOrderValidator(null, dataComponents);
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

    @Test
    void whenPelvisWidthNull() {
        Database database = Mockito.mock(Database.class);
        ClientRequest request = Mockito.mock(ClientRequest.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ClientOrderValidator(null, dataComponents);
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
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }

    @Test
    void whenThighLengthNull() {
        Database database = Mockito.mock(Database.class);
        ClientRequest request = Mockito.mock(ClientRequest.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ClientOrderValidator(null, dataComponents);
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
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }

    @Test
    void whenBackLengthNull() {
        Database database = Mockito.mock(Database.class);
        ClientRequest request = Mockito.mock(ClientRequest.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ClientOrderValidator(null, dataComponents);
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
            assertEquals(errors.get(0).getMessage(), "Must not be empty!");

    }

    @Test
    public  void indexBrakeAndArmrestIsAbsent() {
        Database database = Mockito.mock(Database.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        ClientRequest request = new ClientRequest("Ivanov", 12, "Lesnaja, 22",
                33, 33, 33, 33,
                11, 21, 34, 45);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ClientOrderValidator(database, dataComponents);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
        assertEquals(errors.get(1).getField(), "indexArmrest");
        assertEquals(errors.get(1).getMessage(), "This index is absent!");

    }




}