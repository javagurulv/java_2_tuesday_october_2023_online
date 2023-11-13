package lv.javaguru.java2.cakeConstructor.newApp.database;

import java.util.ArrayList;
import java.util.List;

public class Database implements DatabaseImpl{

    private Long nextId=1L;
    private List<Ingridient> ingridients = new ArrayList<>();


    @Override
    public void save(Ingridient ingridient) {
        ingridient.setId(nextId);
        nextId++;
        ingridients.add(ingridient);
    }

    @Override
    public void deleteById(Long id) {
        ingridients.stream()
                .filter(ingridient -> ingridient.getId().equals(id))
                .findFirst()
                .ifPresent(ingridient -> ingridients.remove(ingridient));
    }

    @Override
    public List<Ingridient> getAllIngridients() {
        return ingridients;
    }
}
