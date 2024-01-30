package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;

import java.util.List;

public class GetAllCakesResponse extends CoreResponse {

    private List<Cake> cakes;

    public GetAllCakesResponse(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public List<Cake> getCakes() {
        return cakes;
    }

}
