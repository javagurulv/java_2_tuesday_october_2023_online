package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.services.RemoveIngridientService;

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
        service.execute(ingrientId);
        System.out.println("Your ingridient was removed from list.");
    }
}
