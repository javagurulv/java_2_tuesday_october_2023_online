package lv.javaguru.java2.cakeConstructor.services;

import lv.javaguru.java2.cakeConstructor.database.DataBase;
import lv.javaguru.java2.cakeConstructor.domain.Cake;
import lv.javaguru.java2.cakeConstructor.domain.ListOfIngridients;

public class AddCakeService {

    private DataBase dataBase;
    private ListOfIngridients list = new ListOfIngridients();
    public AddCakeService (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public void execute(int clientId){
        Cake cake = list.createCake(clientId);
        dataBase.add(cake);
    }
}
