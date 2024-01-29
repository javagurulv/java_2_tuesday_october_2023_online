package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RegisterClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddIngredientRequestValidatorTest {

    @Mock
    private JpaIngredientRepository ingredientRepository;
    @InjectMocks
    private AddIngredientRequestValidator validator;

    @Test
    public void shouldReturnErrorWhenTypeIsNull() {
        AddIngredientRequest request = new AddIngredientRequest(null, "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenTasteIsNull() {
        AddIngredientRequest request = new AddIngredientRequest("Biscuit", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "taste");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenTypeAndTasteIsNull() {
        AddIngredientRequest request = new AddIngredientRequest(null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 2);
    }

    @Test
    public void shouldSuccess() {
        AddIngredientRequest request = new AddIngredientRequest("Biscuit", "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenDuplicateFound() {
        ingredientRepository = Mockito.mock(JpaIngredientRepository.class);
        Mockito.when(ingredientRepository.findByTypeAndTaste("Biscuit", "Vanilla")).thenReturn(List.of(new Ingredient("Biscuit", "Vanilla")));
        validator = new AddIngredientRequestValidator(ingredientRepository);
        AddIngredientRequest request = new AddIngredientRequest("Biscuit", "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertTrue(!errors.isEmpty());
        assertEquals(errors.get(0).getField(), "duplicate");
        assertEquals(errors.get(0).getMessage(), "Duplicate ingredient not accepted!");
    }

    @Test
    public void shouldNotReturnErrorWhenDuplicateNotFound() {
        ingredientRepository = Mockito.mock(JpaIngredientRepository.class);
        Mockito.when(ingredientRepository.findByTypeAndTaste("Biscuit", "Vanilla")).thenReturn(List.of());
        validator = new AddIngredientRequestValidator(ingredientRepository);
        AddIngredientRequest request = new AddIngredientRequest("Biscuit", "Vanilla");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}
