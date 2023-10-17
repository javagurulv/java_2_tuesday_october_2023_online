package services;

import database.DataBase;
import domain.Cake;

import java.util.List;

public class GetCakesForClientService {
    private DataBase dataBase;
    public GetCakesForClientService (DataBase dataBase){
        this.dataBase=dataBase;
    }

    public void execute(int clientId){
        List<Cake> cakes = dataBase.getAllCake();
        for (Cake cake : cakes) {
            if (clientId == cake.getClientId()) {
                System.out.println(cake);
            }
        }
    }
}
