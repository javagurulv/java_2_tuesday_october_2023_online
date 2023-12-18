package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import lv.javaguru.java2.cakeConstructor.newApp.DatabaseCleaner;
import lv.javaguru.java2.cakeConstructor.newApp.config.CakeConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngredientsService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CakeConfiguration.class})
@Sql({"/schema.sql"})
public class GetAllIngredientsAcceptanceTest {

    @Autowired private AddIngredientService addIngredientService;
    @Autowired private GetAllIngredientsService getAllIngredientsService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void shouldReturnCorrectIngredientList() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        addIngredientService.execute(addIngredientRequest1);

        AddIngredientRequest addIngredientRequest2 = new AddIngredientRequest("Biscuit", "Vanilla");
        addIngredientService.execute(addIngredientRequest2);

        GetAllIngredientsRequest getAllIngredientsRequest3 = new GetAllIngredientsRequest();
        GetAllIngredientsResponse response = getAllIngredientsService.execute(getAllIngredientsRequest3);

        assertEquals(response.getIngredients().size(), 2);
    }


}

