package lv.javaguru.java2.cakeConstructor.services;


import lv.javaguru.java2.cakeConstructor.core.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.request.GetAllCakesForClientRequest;
import lv.javaguru.java2.cakeConstructor.core.responses.GetAllCakesForClientResponse;

import java.util.List;

public class GetCakesForClientService {
    private DataBase dataBase;
    public GetCakesForClientService (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public GetAllCakesForClientResponse execute(GetAllCakesForClientRequest request){
        List<Cake> cakes = dataBase.getAllCake();
        return new GetAllCakesForClientResponse(cakes);
    }
}
