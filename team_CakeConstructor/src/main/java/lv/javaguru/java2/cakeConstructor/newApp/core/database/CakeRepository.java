package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;

import java.util.List;
import java.util.Optional;

public interface CakeRepository {
    void save(Cake cake);

    Optional<Cake> getById(Long id);

    boolean deleteById(Long id);

    List<Cake> getAllCakes();

    List<Cake> findByCakeName(String cakeName);

    List<Cake> findByWeight(double weight);

    List<Cake> findByCakeNameAndWeight(String cakeName, double weight);
}



