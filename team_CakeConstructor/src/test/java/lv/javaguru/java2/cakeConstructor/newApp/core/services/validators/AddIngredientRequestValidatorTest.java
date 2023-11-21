package lv.javaguru.java2.cakeConstructor.newApp.core.services.validators;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddIngredientRequestValidatorTest {

    private AddIngredientRequestValidator validator = new AddIngredientRequestValidator();

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

}
