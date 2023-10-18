package lv.javaguru.java2.cakeConstructor.core.responses;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;

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
