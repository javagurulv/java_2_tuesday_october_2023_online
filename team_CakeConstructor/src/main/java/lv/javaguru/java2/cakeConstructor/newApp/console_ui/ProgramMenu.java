package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgramMenu {

    private Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddIngredientUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, RemoveIngredientUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, GetAllIngredientsUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, SearchIngredientsUIAction.class));
        menuNumberToUIActionMap.put(5, findUIAction(uiActions, UpdateIngredientUIAction.class));
        menuNumberToUIActionMap.put(6, findUIAction(uiActions, RegisterClientUIAction.class));
        menuNumberToUIActionMap.put(7, findUIAction(uiActions, RemoveClientUIAction.class));
        menuNumberToUIActionMap.put(8, findUIAction(uiActions, PrintAllClientsUIAction.class));
        menuNumberToUIActionMap.put(9, findUIAction(uiActions, SearchClientsUIAction.class));
        menuNumberToUIActionMap.put(10, findUIAction(uiActions, UpdateClientUIAction.class));
        menuNumberToUIActionMap.put(11, findUIAction(uiActions, ExitUIAction.class));
    }

    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public void printProgramMenu() {
        System.out.println();
        System.out.println("Program menu:");
        System.out.println("1. Add ingredient to list");
        System.out.println("2. Delete ingredient from list");
        System.out.println("3. Show all ingredients in the list");
        System.out.println("4. Search ingredients");
        System.out.println("5. Update ingredient");
        System.out.println("6. Register new client");
        System.out.println("7. Delete client");
        System.out.println("8. Show all clients");
        System.out.println("9. Search clients");
        System.out.println("10. Update client");
        System.out.println("11. Exit");
        System.out.println();
    }

    public int getUserChoice(){
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeSelectedMenuItem(int selectedMenu) { menuNumberToUIActionMap.get(selectedMenu).execute(); }

}
