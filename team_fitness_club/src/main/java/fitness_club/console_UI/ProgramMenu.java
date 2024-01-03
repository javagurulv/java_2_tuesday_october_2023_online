package fitness_club.console_UI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ProgramMenu {

    private static Map<Integer, UIAction> menuNumberToUIActionMap;

    @Autowired
    public ProgramMenu(List<UIAction> uiActions) {
        menuNumberToUIActionMap = new HashMap<>();
        menuNumberToUIActionMap.put(1, findUIAction(uiActions, AddClientUIAction.class));
        menuNumberToUIActionMap.put(2, findUIAction(uiActions, RemoveClientUIAction.class));
        menuNumberToUIActionMap.put(3, findUIAction(uiActions, GetAllClientsUIAction.class));
        menuNumberToUIActionMap.put(4, findUIAction(uiActions, CreateMemberCardUIAction.class));
       // menuNumberToUIActionMap.put(5, findUIAction(uiActions, ChangeWorkoutUIAction.class));
       // menuNumberToUIActionMap.put(6, findUIAction(uiActions, ChangeClientAgeGroupUIAction.class));
       // menuNumberToUIActionMap.put(7, findUIAction(uiActions, ChangeClientFitnessCentreUIAction.class));
        menuNumberToUIActionMap.put(8, findUIAction(uiActions, SearchClientUIAction.class));
        menuNumberToUIActionMap.put(9, findUIAction(uiActions, ExitUIAction.class));
    }


    private UIAction findUIAction(List<UIAction> uiActions, Class uiActionClass) {
        return uiActions.stream()
                .filter(uiAction -> uiAction.getClass().equals(uiActionClass))
                .findFirst()
                .get();
    }

    public static void printProgramMenu() {
        System.out.println("");
        System.out.println("Program menu:");
        System.out.println("1. Add client to list");
        System.out.println("2. Delete client from list");
        System.out.println("3. Show all clients in the list");
        System.out.println("4. Create client member card");
        //System.out.println("5. Change client workout");
       // System.out.println("6. Change client age group");
      //  System.out.println("7. Change client fitness centre");
        System.out.println("8. Search clients in database");
        System.out.println("9. Exit");
        System.out.println("");
    }

    public static int getMenuNumber() {
        System.out.println("Enter menu item number to execute: ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void executeSelectedMenuItem(int selectedMenu) {
        menuNumberToUIActionMap.get(selectedMenu).execute();
    }
}
