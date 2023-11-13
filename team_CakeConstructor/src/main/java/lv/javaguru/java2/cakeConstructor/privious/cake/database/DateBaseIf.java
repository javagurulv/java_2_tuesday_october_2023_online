package lv.javaguru.java2.cakeConstructor.privious.cake.database;

import lv.javaguru.java2.cakeConstructor.privious.cake.domain.Cake;

import java.util.List;

public interface DateBaseIf {


    void add(Cake cake1);

    List<Cake> getCakesForClient(String clientLogin);

    List<Cake> getAllCake();
    void saveCake();
}
