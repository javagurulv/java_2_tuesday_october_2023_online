package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.AddIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIComponent;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIDependency;

import java.util.Scanner;
@DIComponent
public class AddIngredientUIAction implements UIAction {

    @DIDependency
    private AddIngredientService addIngredientService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient type: ");
        String typeOfIngredient = scanner.nextLine();
        System.out.println("Enter ingredient taste: ");
        String tasteOfIngredient = scanner.nextLine();
        AddIngredientRequest request = new AddIngredientRequest(typeOfIngredient, tasteOfIngredient);
        AddIngredientResponse response = addIngredientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("New ingredient id was: " + response.getNewIngredient().getId());
            System.out.println("Your ingredient was added to list.");
        }
    }
}
