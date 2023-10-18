package lv.javaguru.java2.cakeConstructor.core.responses;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;

public class AddCakeResponse {

    private Cake newCake;

    public AddCakeResponse (Cake newCake){
        this.newCake = newCake;
    }

    public Cake getNewCake() {
        return newCake;
    }

}
