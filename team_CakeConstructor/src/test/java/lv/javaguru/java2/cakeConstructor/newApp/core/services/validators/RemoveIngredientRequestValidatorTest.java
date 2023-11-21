package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RemoveIngredientRequestValidatorTest {

    private RemoveIngredientRequestValidator validator = new RemoveIngredientRequestValidator();

    @Test
    public void shouldReturnErrorWhenTitleIsNull() {
        RemoveIngredientRequest request = new RemoveIngredientRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "ingredientId");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        RemoveIngredientRequest request = new RemoveIngredientRequest(1L);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}