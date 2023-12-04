package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.java2.cakeConstructor.newApp.config.CakeConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;

import static org.junit.Assert.assertTrue;

public class AddIngredientAcceptanceTest {

    private ApplicationContext appContext;

    @Before
    public void setup() { appContext = new AnnotationConfigApplicationContext(CakeConfiguration.class); }

    @Test
    public void shouldReturnErrorWhenTypeNotProvided() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest(null, "Vanilla");
        getAddIngredientService().execute(addIngredientRequest1);

        AddIngredientResponse response = getAddIngredientService().execute(addIngredientRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "type");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenTasteNotProvided() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", null);
        getAddIngredientService().execute(addIngredientRequest1);

        AddIngredientResponse response = getAddIngredientService().execute(addIngredientRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "taste");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnIngredient() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        getAddIngredientService().execute(addIngredientRequest1);

        SearchIngredientsRequest searchIngredientsRequest2 = new SearchIngredientsRequest("Biscuit", null);
        SearchIngredientsResponse response = getSearchIngredientsService().execute(searchIngredientsRequest2);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla");
    }

    private AddIngredientService getAddIngredientService() { return appContext.getBean(AddIngredientService.class); }

    private SearchIngredientsService getSearchIngredientsService() { return appContext.getBean(SearchIngredientsService.class); }

}

