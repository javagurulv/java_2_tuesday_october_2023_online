package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RemoveIngredientRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RemoveIngredientServiceTest {

    @Mock private Database database;
    @Mock private RemoveIngredientRequestValidator validator;
    @InjectMocks private RemoveIngredientService service;

    @Test
    public void shouldReturnErrorWhenIngredientIdNotProvided() {
        RemoveIngredientRequest request = new RemoveIngredientRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ingredientId", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveIngredientResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ingredientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldDeleteIngredientWithIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(database.deleteById(1L)).thenReturn(true);
        RemoveIngredientRequest request = new RemoveIngredientRequest(1L);
        RemoveIngredientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isIngredientRemoved());
    }

}