package lv.javaguru.java2.product.storage.console_ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddProductUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, RemoveProductUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, PrintAllProductsUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, SearchProductsUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, ExitProgramUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printMenu() {
        System.out.println();
        System.out.println("Menu: ");
        System.out.println("Press 1: Add product to list: ");
        System.out.println("Press 2: Remove product from list: ");
        System.out.println("Press 3: Display all products in the list: ");
        System.out.println("Press 4. Search products");
        System.out.println("Press 5: Exit from program.");
        System.out.println();
    }

    public int getUserMenuChoice() {
        System.out.println("Enter menu item number to execute: ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) { menuNumberToUIActionMap.get(selectedMenu).execute(); }

}
