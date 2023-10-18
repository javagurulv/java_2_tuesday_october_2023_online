package lv.javaguru.java2.cakeConstructor.core.services;

import lv.javaguru.java2.cakeConstructor.core.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.request.GetAllCakesForClientRequest;
import lv.javaguru.java2.cakeConstructor.core.responses.GetAllCakesForClientResponse;

import java.util.ArrayList;
import java.util.List;

public class GetCakesForClientService {
    private DataBase dataBase;
    public GetCakesForClientService (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public GetAllCakesForClientResponse execute(GetAllCakesForClientRequest request){
        List<Cake> cakes = dataBase.getAllCake();
        Cake cake1 = null;
        for (Cake cake : cakes) {
            if (request.getClientId() == cake.getClientId()) {
                cake1=cake;
                System.out.println(cake.toString());
            }
        }
        return new GetAllCakesForClientResponse(cake1);
    }
}
