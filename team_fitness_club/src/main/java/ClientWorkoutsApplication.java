import console_UI.*;
import database.*;
import services.*;

import java.util.Scanner;

public class ClientWorkoutsApplication {
    public static void main(String[] args) {
        Database database = new InFileDatabase();
        AddClientService addClientService = new AddClientService(database);
        DeleteClientService deleteClientService = new DeleteClientService(database);
        GetAllClientsService getAllClientsService = new GetAllClientsService(database);
        ChangeClientWorkoutService changeClientWorkoutService = new ChangeClientWorkoutService(database);

        AddClientUIAction addClientUIAction = new AddClientUIAction(addClientService);
        DeleteClientUIAction deleteClientUIAction = new DeleteClientUIAction(deleteClientService);
        GetAllClientsUIAction getAllClientsUIAction = new GetAllClientsUIAction(getAllClientsService);
        ChangeWorkoutUIAction changeWorkoutUIAction = new ChangeWorkoutUIAction(changeClientWorkoutService);
        ExitUIAction exitUIAction = new ExitUIAction();

        while (true) {
            printProgramMenu();
            int userChoiceMenuNumber = getMenuNumber();
            switch (userChoiceMenuNumber) {
                case 1: {
                    addClientUIAction.execute();
                    break;
                }
                case 2:
                    deleteClientUIAction.execute();
                    break;
                case 3:
                    getAllClientsUIAction.execute();
                    break;
                case 4:
                    changeWorkoutUIAction.execute();
                    break;
                case 5:
                    exitUIAction.execute();
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
        System.out.println("5. Exit");
        System.out.println("");
    }

    public static int getMenuNumber() {
        System.out.println("Enter menu item number to execute: ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
