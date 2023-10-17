package consoole_ui;

import database.DataBase;
import domain.Cake;

import java.util.List;
import java.util.Scanner;

public class GetAllCakesForClientUIAction implements UIAction{
    private DataBase dataBase;
    public  GetAllCakesForClientUIAction( DataBase dataBase){
        this.dataBase=dataBase;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your client ID!");
        int clientId = scan.nextInt();
        List<Cake> cakes = dataBase.getAllCake();
        for (Cake cake : cakes) {
            if (clientId == cake.getClientId()) {
                System.out.println(cake);
            }
        }
    }
}
