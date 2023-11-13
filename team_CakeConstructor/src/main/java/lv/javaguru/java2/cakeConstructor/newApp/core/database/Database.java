package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public boolean deleteById(Long id) {
        ingridients.stream()
                .filter(ingridient -> ingridient.getId().equals(id))
                .findFirst()
                .ifPresent(ingridient -> ingridients.remove(ingridient));
        return false;
    }

    @Override
    public List<Ingridient> getAllIngridients() {
        return ingridients;
    }

    @Override
    public List<Ingridient> findByType(String type){
        return ingridients.stream()
                .filter(ingridient -> ingridient.getType().equals(type))
                .collect(Collectors.toList());
    }
    @Override
    public List<Ingridient> findByTypeAndTaste(String type, String taste) {
        return ingridients.stream()
                .filter(ingridient -> ingridient.getType().equals(type))
                .filter(ingridient -> ingridient.getTaste().equals(taste))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ingridient> findByTaste (String taste){
        return ingridients.stream()
                .filter(ingridient -> ingridient.getTaste().equals(taste))
                .collect(Collectors.toList());
    }
}
