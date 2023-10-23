package lv.javaguru.java2.cakeConstructor.core.cake.database;

import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;

import java.util.ArrayList;
import java.util.List;

public class DataBase implements DateBaseIf {
    private List<Cake> cakes = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public void add(Cake cake) {
        cake.setClientId(cake.getClientLogin());
        cakes.add(cake);
    }

    @Override
    public List<Cake> getCakesForClient(String clientLogin) {
        List<Cake> cakeForClientId = new ArrayList<>();
        for (Cake cake : cakes) {
            if (clientLogin == cake.getClientLogin()) {
                cakeForClientId.add(cake);
            }
        }
        return cakeForClientId;
    }


    @Override
    public List<Cake> getAllCake() {
        return cakes;
    }

    @Override
    public void saveCake() {
    }
}
