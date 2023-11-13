package lv.javaguru.java2.cakeConstructor.privious.consoole_ui;

import lv.javaguru.java2.cakeConstructor.privious.cake.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.privious.cake.responses.AddCakeResponse;
import lv.javaguru.java2.cakeConstructor.privious.cake.services.AddCakeService;

public class AddCakeUIAction implements UIAction {

    private AddCakeService addCakeService;

    public AddCakeUIAction(AddCakeService addCakeService){
        this.addCakeService = addCakeService;
    }

    @Override
    public void execute(String clientLogin) {

        AddCakeRequest request = new AddCakeRequest(clientLogin);
        AddCakeResponse response = addCakeService.execute(request);
        response.getNewCake().toString();

    }

    @Override
    public void execute() {

    }
}
