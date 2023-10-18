package lv.javaguru.java2.cakeConstructor.services;


import lv.javaguru.java2.cakeConstructor.core.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.domain.ListOfIngridients;
import lv.javaguru.java2.cakeConstructor.core.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.core.responses.AddCakeResponse;

public class AddCakeService {

    private DataBase dataBase;
    private ListOfIngridients list = new ListOfIngridients();
    public AddCakeService (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public AddCakeResponse execute(AddCakeRequest request){
        Cake cake = list.createCake(request.getClientId());
        dataBase.add(cake);
        return new AddCakeResponse(cake);
    }
}
