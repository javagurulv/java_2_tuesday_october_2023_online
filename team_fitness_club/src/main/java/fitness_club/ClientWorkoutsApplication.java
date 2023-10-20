package fitness_club;

import fitness_club.console_UI.*;
import fitness_club.data_vlidation.AddClientRequestValidator;
import fitness_club.database.Database;
import fitness_club.database.InMemoryDatabase;
import fitness_club.services.*;

import java.util.Scanner;

public class ClientWorkoutsApplication {
    public static void main(String[] args) {
        Database database = new InMemoryDatabase();
        AddClientRequestValidator addClientValidator = new AddClientRequestValidator();
        AddClientService addClientService = new AddClientService(database, addClientValidator);
        DeleteClientService deleteClientService = new DeleteClientService(database);
        GetAllClientsService getAllClientsService = new GetAllClientsService(database);
        ChangeClientAgeGroupService changeClientAgeGroupService = new ChangeClientAgeGroupService(database);
        ChangeClientWorkoutService changeClientWorkoutService = new ChangeClientWorkoutService(database);

        AddClientUIAction addClientUIAction = new AddClientUIAction(addClientService);
        DeleteClientUIAction deleteClientUIAction = new DeleteClientUIAction(deleteClientService);
        GetAllClientsUIAction getAllClientsUIAction = new GetAllClientsUIAction(getAllClientsService);
        ChangeClientAgeGrpoupUIAction changeClientAgeGrpoupUIAction = new ChangeClientAgeGrpoupUIAction(changeClientAgeGroupService);
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
                    changeClientAgeGrpoupUIAction.execute();
                    break;
                case 6:
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
        System.out.println("5. Change client age group");
        System.out.println("6. Exit");
        System.out.println("");
    }

    public static int getMenuNumber() {
        System.out.println("Enter menu item number to execute: ");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
