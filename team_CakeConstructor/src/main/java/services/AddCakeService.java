package services;

import database.DataBase;
import domain.Cake;
import domain.ListOfIngridients;

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
