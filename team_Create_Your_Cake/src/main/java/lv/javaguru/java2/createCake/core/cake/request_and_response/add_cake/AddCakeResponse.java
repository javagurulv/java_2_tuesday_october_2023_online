package lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.request_and_response.CoreError;

import java.util.List;

public class AddCakeResponse {

    private Cake newCake;
    public AddCakeResponse (List<CoreError> error) {
        super();
    }

    public AddCakeResponse (Cake newCake){
        this.newCake=newCake;
    }
    public Cake getNewCake(){
        return newCake;
    }
}
