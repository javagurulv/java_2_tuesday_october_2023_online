package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.request.RemoveIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngridientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RemoveIngridientService;

import java.util.Scanner;

public class RemoveIngridientUIAction implements UIAction {

    private RemoveIngridientService service;
    public RemoveIngridientUIAction (RemoveIngridientService service){
        this.service=service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of ingridient:  ");
        Long ingrientId = Long.parseLong(scanner.nextLine());
        RemoveIngridientRequest request = new RemoveIngridientRequest(ingrientId);
        RemoveIngridientResponse response = service.execute(request);
        if (response.isIngridientRemoved()) {
            System.out.println("Your ingridient was removed from list.");
        } else {
            System.out.println("Your ingridient not removed from list.");
        }
    }
}
