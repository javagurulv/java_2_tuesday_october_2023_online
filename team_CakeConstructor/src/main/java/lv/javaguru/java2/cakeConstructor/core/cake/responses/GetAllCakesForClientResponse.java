package lv.javaguru.java2.cakeConstructor.core.cake.responses;

import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;

import java.util.List;

public class GetAllCakesForClientResponse {

    private List<Cake> cakes;


    public GetAllCakesForClientResponse(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public List<Cake> getCakes() {
        return cakes;
    }
}
