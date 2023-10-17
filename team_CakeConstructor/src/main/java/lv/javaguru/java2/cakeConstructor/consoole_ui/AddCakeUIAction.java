package lv.javaguru.java2.cakeConstructor.consoole_ui;

import lv.javaguru.java2.cakeConstructor.services.AddCakeService;

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
