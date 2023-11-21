package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Ingredient;

import java.util.List;

public interface Database {

    void save(Ingredient ingredient);

    boolean deleteById(Long id);

    List<Ingredient> getAllIngredients();

    List<Ingredient> findByType(String type);

    List<Ingredient> findByTaste(String taste);

    List<Ingredient> findByTypeAndTaste(String type, String taste);

}
