package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;

import java.util.List;

public class AddIngridientResponse {

    private Ingridient newIngridient;

    public Ingridient getNewIngridient() {
        return newIngridient;
    }

    public AddIngridientResponse(List<CoreError> errors) {
        super();
    }

    public AddIngridientResponse (Ingridient ingridient){
        this.newIngridient=ingridient;
    }
}
