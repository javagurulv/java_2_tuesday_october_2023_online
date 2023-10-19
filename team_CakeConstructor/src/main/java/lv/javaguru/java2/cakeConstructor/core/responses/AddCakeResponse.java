package lv.javaguru.java2.cakeConstructor.core.responses;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;

import java.util.List;

public class AddCakeResponse extends CoreResponse {

    private Cake newCake;
    public AddCakeResponse (List<CoreError> error){
        super(error);
    }

    public AddCakeResponse (Cake newCake){
        this.newCake = newCake;
    }

    public Cake getNewCake() {
        return newCake;
    }

}
