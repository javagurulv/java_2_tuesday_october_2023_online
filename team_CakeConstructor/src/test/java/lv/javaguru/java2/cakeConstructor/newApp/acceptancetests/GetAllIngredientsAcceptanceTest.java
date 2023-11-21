package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.ApplicationContext;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngredientsService;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIApplicationContextBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetAllIngredientsAcceptanceTest {

    private ApplicationContext appContext =
            new DIApplicationContextBuilder().build("lv.javaguru.java2.cakeConstructor.newApp");

    @Test
    public void shouldReturnCorrectIngredientList() {
        AddIngredientRequest addIngredientRequest1 = new AddIngredientRequest("Biscuit", "Vanilla");
        getAddIngredientService().execute(addIngredientRequest1);

        AddIngredientRequest addIngredientRequest2 = new AddIngredientRequest("Biscuit", "Vanilla");
        getAddIngredientService().execute(addIngredientRequest2);

        GetAllIngredientsRequest getAllIngredientsRequest3 = new GetAllIngredientsRequest();
        GetAllIngredientsResponse response = getAllIngredientsService().execute(getAllIngredientsRequest3);

        assertEquals(response.getIngredients().size(), 2);
    }

    private AddIngredientService getAddIngredientService() {
        return appContext.getBean(AddIngredientService.class);
    }

    private GetAllIngredientsService getAllIngredientsService() { return appContext.getBean(GetAllIngredientsService.class);
    }

}

