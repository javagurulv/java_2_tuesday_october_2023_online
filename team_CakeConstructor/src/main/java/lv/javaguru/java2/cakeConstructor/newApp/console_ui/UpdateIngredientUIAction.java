package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.UpdateIngredientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.UpdateIngredientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.UpdateIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateIngredientUIAction implements UIAction {

    @Autowired private UpdateIngredientService updateIngredientService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient id to update: ");
        Long ingredientId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new type: ");
        String newTypeOfIngredient = scanner.nextLine();
        System.out.println("Enter new taste: ");
        String newTasteOfIngredient = scanner.nextLine();
        UpdateIngredientRequest request = new UpdateIngredientRequest(ingredientId, newTypeOfIngredient, newTasteOfIngredient);
        UpdateIngredientResponse response = updateIngredientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Your ingredient was updated" + response.getUpdatedIngredient());

        }
    }
}
