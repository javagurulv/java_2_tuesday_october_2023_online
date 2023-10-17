package lv.javaguru.java2.cakeConstructor.database;

import lv.javaguru.java2.cakeConstructor.domain.Cake;

import java.util.List;

public interface DateBaseIf {


    void add(Cake cake1);

    List<Cake> getCakesForClient(int clientId);

    List<Cake> getAllCake();
    void saveCake(List<Cake> cakes);
}
