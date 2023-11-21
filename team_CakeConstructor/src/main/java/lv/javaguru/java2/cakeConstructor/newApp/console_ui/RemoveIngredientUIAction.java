package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RemoveIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIComponent;
import lv.javaguru.java2.cakeConstructor.newApp.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class RemoveIngredientUIAction implements UIAction {

    @DIDependency
    private RemoveIngredientService removeIngredientService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient id to remove: ");
        Long ingredientId = Long.parseLong(scanner.nextLine());
        RemoveIngredientRequest request = new RemoveIngredientRequest(ingredientId);
        RemoveIngredientResponse response = removeIngredientService.execute(request);


        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isIngredientRemoved()) {
                System.out.println("Your ingredient was removed from list.");
            } else {
                System.out.println("Your ingredient not removed from list.");
            }
        }
    }
}
