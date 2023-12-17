package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.cakeConstructor.newApp.DatabaseCleaner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import lv.javaguru.java2.cakeConstructor.newApp.config.CakeConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CakeConfiguration.class})
@Sql({"/schema.sql"})
public class AddIngredientAcceptanceTest {

    @Autowired private AddIngredientService addIngredientService;
    @Autowired private SearchIngredientsService searchIngredientsService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }


    @Test
    public void shouldReturnErrorWhenTypeNotProvided() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest(null, "Vanilla");
        addIngredientService.execute(addIngredientRequest1);

        AddIngredientResponse response = addIngredientService.execute(addIngredientRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "type");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenTasteNotProvided() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", null);
        addIngredientService.execute(addIngredientRequest1);

        AddIngredientResponse response = addIngredientService.execute(addIngredientRequest1);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "taste");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnIngredient() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        addIngredientService.execute(addIngredientRequest1);

        SearchIngredientsRequest searchIngredientsRequest2 = new SearchIngredientsRequest("Biscuit", null);
        SearchIngredientsResponse response = searchIngredientsService.execute(searchIngredientsRequest2);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla");
    }

}

