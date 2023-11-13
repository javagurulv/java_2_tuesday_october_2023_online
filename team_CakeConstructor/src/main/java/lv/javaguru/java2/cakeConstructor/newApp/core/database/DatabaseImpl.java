package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import java.util.List;

public interface DatabaseImpl {

    void save(Ingridient ingridient);

    boolean deleteById(Long id);

    List<Ingridient> getAllIngridients();

    List<Ingridient> findByType(String type);

    List<Ingridient> findByTypeAndTaste(String type, String taste);

    List<Ingridient> findByTaste(String taste);
}
