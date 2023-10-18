package lv.simpleInventory.console_UI;

import lv.simpleInventory.services.RemoveProductsService;

import java.util.Scanner;

public class RemoveProductsUIAction implements UIAction {

    private RemoveProductsService removeProductsService;

    public RemoveProductsUIAction(RemoveProductsService removeProductsService){
        this.removeProductsService = removeProductsService;
    }



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID");
        Long productId = Long.parseLong(scanner.nextLine());
        removeProductsService.execute(productId);
        System.out.println("Product has been removed");
    }
}
