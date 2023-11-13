package lv.javaguru.java2.cakeConstructor.newApp.database;

import java.util.List;

public interface DatabaseImpl {

    void save(Ingridient ingridient);

    void deleteById(Long id);

    List<Ingridient> getAllIngridients();
}
