package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.CakeIngredient;

import java.util.List;
import java.util.Optional;

public interface CakeIngredientRepository {

    void save(CakeIngredient cakeIngredient);

    Optional<CakeIngredient> getById(Long id);

    boolean deleteById(Long id);

    List<CakeIngredient> getAllCakeIngredients(Cake cake);


}



