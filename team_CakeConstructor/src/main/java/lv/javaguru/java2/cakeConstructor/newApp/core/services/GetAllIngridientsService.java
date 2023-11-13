package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.GetAllIngridientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngridientsResponse;
import lv.javaguru.java2.cakeConstructor.privious.cake.request.GetAllCakesForClientRequest;

import java.util.List;

public class GetAllIngridientsService {

    private DatabaseImpl database;

    public GetAllIngridientsService (DatabaseImpl database){
        this.database=database;
    }

    public GetAllIngridientsResponse execute(GetAllIngridientsRequest request){
        List<Ingridient> ingridients = database.getAllIngridients();
        return new GetAllIngridientsResponse(ingridients);
    }
}
