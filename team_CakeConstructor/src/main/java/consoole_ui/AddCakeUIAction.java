package consoole_ui;

import database.DataBase;
import domain.Cake;
import domain.ListOfIngridients;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddCakeUIAction implements UIAction {

    private DataBase dateBase;
    private ListOfIngridients list = new ListOfIngridients();
    public AddCakeUIAction(DataBase dataBase){
        this.dateBase = dataBase;
    }
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter your client ID!");
        int clientId = scan.nextInt();
        Cake cake = list.createCake(clientId);
        dateBase.add(cake);
        System.out.println("Your book was added to list!");
    }
}
