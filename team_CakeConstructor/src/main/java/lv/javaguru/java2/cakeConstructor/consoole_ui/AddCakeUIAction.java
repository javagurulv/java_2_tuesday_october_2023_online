package lv.javaguru.java2.cakeConstructor.consoole_ui;

import lv.javaguru.java2.cakeConstructor.core.cake.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.AddCakeResponse;
import lv.javaguru.java2.cakeConstructor.core.cake.services.AddCakeService;


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
        String clientLogin = scan.nextLine();
        AddCakeRequest request = new AddCakeRequest(clientLogin);
        AddCakeResponse response = addCakeService.execute(request);
        response.getNewCake().toString();

    }
}
