package lv.javaguru.java2.cakeConstructor.newApp.core.response;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;

import java.util.List;

public class GetAllIngridientsResponse {
    private List<Ingridient>ingridients;

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public GetAllIngridientsResponse (List<Ingridient> ingridients){
        this.ingridients=ingridients;
    }
}
