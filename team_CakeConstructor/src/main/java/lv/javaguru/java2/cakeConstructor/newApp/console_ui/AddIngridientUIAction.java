package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.services.AddIngridientService;

import java.util.Scanner;

public class AddIngridientUIAction implements UIAction{

    private AddIngridientService service;

    public AddIngridientUIAction (AddIngridientService service){
        this.service=service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of ingridient: ");
        String typeOfIngridient = scanner.nextLine();
        System.out.println("Enter taste of ingridient: ");
        String tasteOfIngridient = scanner.nextLine();
        service.execute(typeOfIngridient,tasteOfIngridient);
        System.out.println("Your book was added to list.");
    }
}
