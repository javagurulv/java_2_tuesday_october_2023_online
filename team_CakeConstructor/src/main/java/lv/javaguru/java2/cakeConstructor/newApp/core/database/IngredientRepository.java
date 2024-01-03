package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    void save(Ingredient ingredient);

    Optional<Ingredient> getById(Long id);

    boolean deleteById(Long id);

    List<Ingredient> getAllIngredients();

    List<Ingredient> findByType(String type);

    List<Ingredient> findByTaste(String taste);

    List<Ingredient> findByTypeAndTaste(String type, String taste);

}
