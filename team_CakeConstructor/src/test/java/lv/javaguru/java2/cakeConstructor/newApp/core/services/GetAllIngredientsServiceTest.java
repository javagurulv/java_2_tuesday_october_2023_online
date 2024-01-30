package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.IngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;

@RunWith(MockitoJUnitRunner.class)
public class GetAllIngredientsServiceTest {

    @Mock
    private JpaIngredientRepository ingredientRepository;
    @InjectMocks
    private GetAllIngredientsService service;

    @Test
    public void shouldGetIngredientsFromDb() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Biscuit", "Vanilla"));
        Mockito.when(ingredientRepository.findAll()).thenReturn(ingredients);

        GetAllIngredientsRequest request = new GetAllIngredientsRequest();
        GetAllIngredientsResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getType(), "Biscuit");
        assertEquals(response.getIngredients().get(0).getTaste(), "Vanilla");
    }

}
