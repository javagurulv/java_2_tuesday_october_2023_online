package consoole_ui;

import database.DataBase;
import domain.Cake;
import domain.ListOfIngridients;
import services.AddCakeService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AddCakeUIAction implements UIAction {

    private AddCakeService addCakeService;

    public AddCakeUIAction(AddCakeService addCakeService){
        this.addCakeService = addCakeService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter your client ID!");
        int clientId = scan.nextInt();
        addCakeService.execute(clientId);
        System.out.println("Your book was added to list!");
    }
}
