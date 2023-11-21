package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.ApplicationContext;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RemoveIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveIngredientAcceptanceTest {

    private ApplicationContext appContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.cakeConstructor.newApp");

    @Test
    public void shouldReturnErrorResponseWhenIngredientIdNotProvided() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        getAddIngredientService().execute(addIngredientRequest1);

        RemoveIngredientRequest removeIngredientRequest2 = new RemoveIngredientRequest(null);
        RemoveIngredientResponse response = getRemoveIngredientService().execute(removeIngredientRequest2);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ingredientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveIngredient() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        getAddIngredientService().execute(addIngredientRequest1);

        RemoveIngredientRequest removeIngredientRequest2 = new RemoveIngredientRequest(1L);
        RemoveIngredientResponse response = getRemoveIngredientService().execute(removeIngredientRequest2);

        assertTrue(response.isIngredientRemoved());
    }

    private AddIngredientService getAddIngredientService() {
        return appContext.getBean(AddIngredientService.class);
    }

    private RemoveIngredientService getRemoveIngredientService() { return appContext.getBean(RemoveIngredientService.class);
    }

}
