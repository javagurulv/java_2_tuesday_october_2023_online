package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.Database;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChooseComponentValidatorTest {

    private ChooseComponentValidator validator;

    @Test
    public  void clientNotFound() {
        Database database = Mockito.mock(Database.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        ChangeComponentRequest request = new ChangeComponentRequest(1, 11, 21, 31, 41);
        Mockito.when(database.getClient(request.getId())).thenReturn(null);
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ChooseComponentValidator(database, dataComponents);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "idClient");
        assertEquals(errors.get(0).getMessage(), "Order with this id not found!");

    }


    @Test
    public  void indexFrontWheelIsAbsent() {
        Database database = Mockito.mock(Database.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        ChangeComponentRequest request = new ChangeComponentRequest(1, 13, 21, 31, 41);
       Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
       Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ChooseComponentValidator(database, dataComponents);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexFrontWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public  void indexBackWheelIsAbsent() {
        Database database = Mockito.mock(Database.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        ChangeComponentRequest request = new ChangeComponentRequest(1, 12, 25, 31, 41);
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ChooseComponentValidator(database, dataComponents);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "indexBackWheel");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");

    }

    @Test
    public  void indexBrakeAndArmrestIsAbsent() {
        Database database = Mockito.mock(Database.class);
        DataComponents dataComponents = Mockito.mock(DataComponents.class);
        ChangeComponentRequest request = new ChangeComponentRequest(1, 12, 22, 34, 44);
        Mockito.when(database.getClient(request.getId())).thenReturn(new Client());
        Mockito.when(dataComponents.getAllIndex()).thenReturn(List.of(11, 12, 21, 22, 31, 32, 41, 42));
        validator = new ChooseComponentValidator(database, dataComponents);
        List<CoreError> errors = validator.validate(request);
        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 2);
        assertEquals(errors.get(0).getField(), "indexBrake");
        assertEquals(errors.get(0).getMessage(), "This index is absent!");
        assertEquals(errors.get(1).getField(), "indexArmrest");
        assertEquals(errors.get(1).getMessage(), "This index is absent!");

    }

}