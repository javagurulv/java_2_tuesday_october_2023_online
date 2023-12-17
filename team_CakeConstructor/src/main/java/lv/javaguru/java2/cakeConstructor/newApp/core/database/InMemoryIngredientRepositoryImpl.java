package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
public class InMemoryIngredientRepositoryImpl implements IngredientRepository {

    private Long nextId=1L;
    private List<Ingredient> ingredients = new ArrayList<>();


    @Override
    public void save(Ingredient ingredient) {
        ingredient.setId(nextId);
        nextId++;
        ingredients.add(ingredient);
    }

    @Override
    public boolean deleteById(Long id) {
        boolean isIngredientDeleted = false;
        Optional<Ingredient> ingredientToDeleteOpt = ingredients.stream()
                .filter(ingredient -> ingredient.getId().equals(id))
                .findFirst();
        if (ingredientToDeleteOpt.isPresent()) {
            Ingredient ingredientToRemove = ingredientToDeleteOpt.get();
            isIngredientDeleted = ingredients.remove(ingredientToRemove);
        }
        return isIngredientDeleted;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }


    @Override
    public List<Ingredient> findByType(String type){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ingredient> findByTaste (String taste){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getTaste().equals(taste))
                .collect(Collectors.toList());
    }
    @Override
    public List<Ingredient> findByTypeAndTaste(String type, String taste) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .filter(ingredient -> ingredient.getTaste().equals(taste))
                .collect(Collectors.toList());
    }

}
