package database;

import domain.Cake;

import java.util.List;

public interface DateBaseIf {


    void add(Cake cake1);

    List<Cake> getCakesForClient(int clientId);

    List<Cake> getAllCake();
    void saveCake(List<Cake> cakes);
}
