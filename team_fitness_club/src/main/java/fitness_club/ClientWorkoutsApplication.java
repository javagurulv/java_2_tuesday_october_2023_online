package fitness_club;

import fitness_club.console_UI.*;
import fitness_club.dependency_injection.ApplicationContext;

import java.util.Scanner;

public class ClientWorkoutsApplication {

    private static ApplicationContext applicationContext = new ApplicationContext();

    public static void main(String[] args) {

        while (true) {
            printProgramMenu();
            int userChoiceMenuNumber = getMenuNumber();
            switch (userChoiceMenuNumber) {
                case 1: {
                    AddClientUIAction uiAction = applicationContext.getBean(AddClientUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 2: {
                    RemoveClientUIAction uiAction = applicationContext.getBean(RemoveClientUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 3: {
                    GetAllClientsUIAction uiAction = applicationContext.getBean(GetAllClientsUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 4: {
                    ChangeWorkoutUIAction uiAction = applicationContext.getBean(ChangeWorkoutUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 5: {
                    ChangeClientAgeGroupUIAction uiAction = applicationContext.getBean(ChangeClientAgeGroupUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 6: {
                    SearchClientUIAction uiAction = applicationContext.getBean(SearchClientUIAction.class);
                    uiAction.execute();
                    break;
                }
                case 7: {
                    ExitUIAction uiAction = applicationContext.getBean(ExitUIAction.class);
                    uiAction.execute();
                    break;
                }
            }
        }
    }

    public static void printProgramMenu() {
        System.out.println("");
        System.out.println("Program menu:");
        System.out.println("1. Add client to list");
        System.out.println("2. Delete client from list");
        System.out.println("3. Show all clients in the list");
        System.out.println("4. Change client workout");
        System.out.println("5. Change client age group");
        System.out.println("6. Search clients in database");
        System.out.println("7. Exit");
        System.out.println("");
    }

    public static int getMenuNumber() {
        System.out.println("Enter menu item number to execute: ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
