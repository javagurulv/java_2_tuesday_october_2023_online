package lv.javaguru.java2.cakeConstructor.core.responses;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.services.GetCakesForClientService;

public class GetAllCakesForClientResponse {

    private Cake cake;

    public Cake getCake() {
        return cake;
    }

    public GetAllCakesForClientResponse (Cake cake){
        this.cake = cake;
    }


}
