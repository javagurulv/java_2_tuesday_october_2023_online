package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.SearchIngredientsRequestValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class SearchIngredientsServiceTest {

    @Mock private Database database;
    @Mock private SearchIngredientsRequestValidator validator;
    @InjectMocks
    private SearchIngredientsService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("type", "Must not be empty!"));
        errors.add(new CoreError("taste", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchIngredientsResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldSearchByType() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla"));
        Mockito.when(database.findByType("Biscuit")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla");
    }

    @Test
    public void shouldSearchByTaste() {
        SearchIngredientsRequest request = new SearchIngredientsRequest(null, "Vanilla");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla"));
        Mockito.when(database.findByTaste("Vanilla")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla");
    }

    @Test
    public void shouldSearchByTypeAndTaste() {
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", "Vanilla");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla"));
        Mockito.when(database.findByTypeAndTaste("Biscuit", "Vanilla")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla");
    }

    @Test
    public void shouldSearchByTypeWithOrderingAscending() {
        Ordering ordering = new Ordering("taste", "ASCENDING");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla2"));
        ingredients.add(new Ingredient("Biscuit", "Vanilla1"));
        Mockito.when(database.findByType("Biscuit")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla2");
    }

    @Test
    public void shouldSearchByTypeWithOrderingDescending() {
        Ordering ordering = new Ordering("taste", "DESCENDING");
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla1"));
        ingredients.add(new Ingredient("Biscuit", "Vanilla2"));
        Mockito.when(database.findByType("Biscuit")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla2");
        assertEquals(response.getIngredients().get(1).getTaste(), "Vanilla1");
    }

    @Test
    public void shouldSearchByTypeWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla1"));
        ingredients.add(new Ingredient("Biscuit", "Vanilla2"));
        Mockito.when(database.findByType("Biscuit")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla1");
    }

    @Test
    public void shouldSearchByTypeWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchIngredientsRequest request = new SearchIngredientsRequest("Biscuit", null, null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla1"));
        ingredients.add(new Ingredient("Biscuit", "Vanilla2"));
        Mockito.when(database.findByType("Biscuit")).thenReturn(ingredients);

        SearchIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla2");
    }

}
