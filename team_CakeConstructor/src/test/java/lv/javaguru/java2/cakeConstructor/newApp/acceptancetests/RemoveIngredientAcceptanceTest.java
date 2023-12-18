package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import lv.javaguru.java2.cakeConstructor.newApp.DatabaseCleaner;
import lv.javaguru.java2.cakeConstructor.newApp.config.CakeConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RemoveIngredientService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CakeConfiguration.class})
@Sql({"/schema.sql"})
public class RemoveIngredientAcceptanceTest {

    @Autowired private AddIngredientService addIngredientService;
    @Autowired private RemoveIngredientService removeIngredientService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnErrorResponseWhenIngredientIdNotProvided() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        addIngredientService.execute(addIngredientRequest1);

        RemoveIngredientRequest removeIngredientRequest2 = new RemoveIngredientRequest(null);
        RemoveIngredientResponse response = removeIngredientService.execute(removeIngredientRequest2);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ingredientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldRemoveIngredient() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        addIngredientService.execute(addIngredientRequest1);

        RemoveIngredientRequest removeIngredientRequest2 = new RemoveIngredientRequest(1L);
        RemoveIngredientResponse response = removeIngredientService.execute(removeIngredientRequest2);

        assertTrue(response.isIngredientRemoved());
    }


}
