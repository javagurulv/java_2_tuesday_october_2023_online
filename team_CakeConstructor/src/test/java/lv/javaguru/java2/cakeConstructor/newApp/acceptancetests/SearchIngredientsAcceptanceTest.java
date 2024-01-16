package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import lv.javaguru.java2.cakeConstructor.newApp.DatabaseCleaner;
import lv.javaguru.java2.cakeConstructor.newApp.config.SpringCoreConfiguration;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;

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
@ContextConfiguration(classes = {SpringCoreConfiguration.class})
@Sql({"/schema.sql"})
public class SearchIngredientsAcceptanceTest {

    @Autowired private AddIngredientService addIngredientService;
    @Autowired private SearchIngredientsService searchIngredientsService;
    @Autowired private DatabaseCleaner databaseCleaner;

    @Before
    public void setup() {
        databaseCleaner.clean();
    }

    @Test
    public void searchIngredients() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        addIngredientService.execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        addIngredientService.execute(request2);

        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null);
        SearchIngredientsResponse response = searchIngredientsService.execute(request3);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
        assertEquals(response.getIngredients().get(1).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla2");
    }


    @Test
    public void searchIngredientsOrderingDescending() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        addIngredientService.execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        addIngredientService.execute(request2);

        Ordering ordering = new Ordering("taste", "DESCENDING");
        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering);
        SearchIngredientsResponse response = searchIngredientsService.execute(request3);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla2");
        assertEquals(response.getIngredients().get(1).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla1");
    }

    @Test
    public void searchIngredientsOrderingAscending() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        addIngredientService.execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        addIngredientService.execute(request2);

        Ordering ordering = new Ordering("taste", "ASCENDING");
        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering);
        SearchIngredientsResponse response = searchIngredientsService.execute(request3);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
        assertEquals(response.getIngredients().get(1).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla2");
    }

    @Test
    public void searchIngredientsOrderingPagingFirstPage() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        addIngredientService.execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        addIngredientService.execute(request2);

        Ordering ordering = new Ordering("taste", "ASCENDING");
        Paging paging = new Paging(1, 1);

        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering, paging);
        SearchIngredientsResponse response = searchIngredientsService.execute(request3);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
    }

    @Test
    public void searchIngredientsOrderingPagingSecondPage() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        addIngredientService.execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        addIngredientService.execute(request2);

        Ordering ordering = new Ordering("taste", "ASCENDING");
        Paging paging = new Paging(2, 1);
        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering, paging);
        SearchIngredientsResponse response = searchIngredientsService.execute(request3);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla2");

    }


}
