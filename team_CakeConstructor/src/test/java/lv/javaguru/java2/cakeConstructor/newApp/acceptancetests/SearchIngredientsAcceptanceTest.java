package lv.javaguru.java2.cakeConstructor.newApp.acceptancetests;

import lv.javaguru.java2.cakeConstructor.newApp.ApplicationContext;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchIngredientsAcceptanceTest {

    private ApplicationContext appContext = new ApplicationContext();

    @Test
    public void searchIngredients() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        getAddIngredientService().execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        getAddIngredientService().execute(request2);

        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null);
        SearchIngredientsResponse response = getSearchIngredientsService().execute(request3);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
        assertEquals(response.getIngredients().get(1).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla2");
    }


    @Test
    public void searchIngredientsOrderingDescending() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        getAddIngredientService().execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        getAddIngredientService().execute(request2);

        Ordering ordering = new Ordering("taste", "DESCENDING");
        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering);
        SearchIngredientsResponse response = getSearchIngredientsService().execute(request3);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla2");
        assertEquals(response.getIngredients().get(1).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla1");
    }

    @Test
    public void searchIngredientsOrderingAscending() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        getAddIngredientService().execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        getAddIngredientService().execute(request2);

        Ordering ordering = new Ordering("taste", "ASCENDING");
        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering);
        SearchIngredientsResponse response = getSearchIngredientsService().execute(request3);

        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
        assertEquals(response.getIngredients().get(1).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla2");
    }

    @Test
    public void searchIngredientsOrderingPagingFirstPage() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        getAddIngredientService().execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        getAddIngredientService().execute(request2);

        Ordering ordering = new Ordering("taste", "ASCENDING");
        Paging paging = new Paging(1, 1);

        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering, paging);
        SearchIngredientsResponse response = getSearchIngredientsService().execute(request3);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
    }

    @Test
    public void searchIngredientsOrderingPagingSecondPage() {
        AddIngredientRequest request1 = new AddIngredientRequest("Biscuit", "Vanilla1");
        getAddIngredientService().execute(request1);

        AddIngredientRequest request2 = new AddIngredientRequest("Biscuit", "Vanilla2");
        getAddIngredientService().execute(request2);

        Ordering ordering = new Ordering("taste", "ASCENDING");
        Paging paging = new Paging(2, 1);
        SearchIngredientsRequest request3 = new SearchIngredientsRequest("Biscuit", null, ordering, paging);
        SearchIngredientsResponse response = getSearchIngredientsService().execute(request3);

        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla2");

    }

    private AddIngredientService getAddIngredientService() {
        return appContext.getBean(AddIngredientService.class);
    }

    private SearchIngredientsService getSearchIngredientsService() {
        return appContext.getBean(SearchIngredientsService.class);
    }

}
