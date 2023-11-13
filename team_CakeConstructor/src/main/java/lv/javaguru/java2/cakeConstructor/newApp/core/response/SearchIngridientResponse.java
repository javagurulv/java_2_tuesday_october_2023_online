package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;

import java.util.List;

public class SearchIngridientResponse extends CoreResponse {

    private List <Ingridient> ingridients;



    public SearchIngridientResponse (List<Ingridient> ingridients, List<CoreError> errors){
        super(errors);
        this.ingridients=ingridients;

    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

}
