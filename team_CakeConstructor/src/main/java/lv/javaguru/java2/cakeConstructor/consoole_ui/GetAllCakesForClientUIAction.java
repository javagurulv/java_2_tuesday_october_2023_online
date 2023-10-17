package lv.javaguru.java2.cakeConstructor.consoole_ui;

import lv.javaguru.java2.cakeConstructor.services.GetCakesForClientService;

import java.util.Scanner;

public class GetAllCakesForClientUIAction implements UIAction{
    private GetCakesForClientService getCakesForClientService;
    public  GetAllCakesForClientUIAction( GetCakesForClientService getCakesForClientService){
        this.getCakesForClientService = getCakesForClientService;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your client ID!");
        int clientId = scan.nextInt();
        getCakesForClientService.execute(clientId);
    }
}
