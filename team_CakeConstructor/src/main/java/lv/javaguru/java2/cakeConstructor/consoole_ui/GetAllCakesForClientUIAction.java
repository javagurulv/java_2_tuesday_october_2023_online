package lv.javaguru.java2.cakeConstructor.consoole_ui;

import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.cake.request.GetAllCakesForClientRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.GetAllCakesForClientResponse;
import lv.javaguru.java2.cakeConstructor.core.cake.services.GetCakesForClientService;

import java.util.Scanner;

public class GetAllCakesForClientUIAction implements UIAction{
    private GetCakesForClientService getCakesForClientService;
    public  GetAllCakesForClientUIAction( GetCakesForClientService getCakesForClientService){
        this.getCakesForClientService = getCakesForClientService;
    }


    @Override
    public void execute(String clientLogin) {
        Scanner scan = new Scanner(System.in);
        GetAllCakesForClientRequest request = new GetAllCakesForClientRequest(clientLogin);
        GetAllCakesForClientResponse response = getCakesForClientService.execute(request);
        for (Cake cake : response.getCakes()) {
            if (request.getClientLogin().equals(cake.getClientLogin())) {
                System.out.println(cake);
            }
        }

    }

    @Override
    public void execute() {

    }
}
