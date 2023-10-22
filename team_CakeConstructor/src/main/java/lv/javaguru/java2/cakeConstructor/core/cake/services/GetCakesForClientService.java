package lv.javaguru.java2.cakeConstructor.core.cake.services;

import lv.javaguru.java2.cakeConstructor.core.cake.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.cake.database.DateBaseIf;
import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.cake.request.GetAllCakesForClientRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.GetAllCakesForClientResponse;

import java.util.List;

public class GetCakesForClientService {
    private DateBaseIf dataBase;
    public GetCakesForClientService (DateBaseIf dataBase){
        this.dataBase=dataBase;
    }

    public GetAllCakesForClientResponse execute(GetAllCakesForClientRequest request){
        List<Cake> cakes = dataBase.getAllCake();
        Cake cake1 = null;
        for (Cake cake : cakes) {
            if (request.getClientLogin() == cake.getClientLogin()) {
                cake1=cake;
            }
        }
        return new GetAllCakesForClientResponse(cakes);
    }
}
