package lv.javaguru.java2.cakeConstructor.consoole_ui;

import lv.javaguru.java2.cakeConstructor.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.request.GetAllCakesForClientRequest;
import lv.javaguru.java2.cakeConstructor.core.responses.GetAllCakesForClientResponse;
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
        GetAllCakesForClientRequest request = new GetAllCakesForClientRequest(clientId);
        GetAllCakesForClientResponse response = getCakesForClientService.execute(request);
        for (Cake cake : response.getCakes()) {
            if (request.getClientId() == cake.getClientId()) {
                System.out.println(cake);
            }
        }

    }
}
