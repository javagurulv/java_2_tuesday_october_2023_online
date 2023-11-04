package fitness_club;

import fitness_club.console_UI.*;
import fitness_club.core.database.Database;
import fitness_club.core.database.InFileDatabase;
import fitness_club.core.services.*;
import fitness_club.data_vlidation.*;

import java.util.Scanner;

public class ClientWorkoutsApplication {
    private static Database database = new InFileDatabase();

    private static AddClientRequestValidator addClientValidator = new AddClientRequestValidator();
    private static RemoveClientRequestValidator deleteClientRequestValidator = new RemoveClientRequestValidator();
    private static ChangeClientAgeGroupValidator changeClientAgeGroupValidator = new ChangeClientAgeGroupValidator();
    private static ChangeClientWorkoutsValidator changeClientWorkoutsValidator = new ChangeClientWorkoutsValidator();
    private static SearchClientRequestFieldValidator fieldValidator = new SearchClientRequestFieldValidator();
    private static OrderingValidator orderingValidator = new OrderingValidator();
    private static PagingValidator pagingValidator = new PagingValidator();
    private static SearchClientRequestValidator searchClientRequestValidator= new SearchClientRequestValidator(fieldValidator, orderingValidator, pagingValidator);

    private static AddClientService addClientService = new AddClientService(database, addClientValidator);
    private static DeleteClientService deleteClientService = new DeleteClientService(database, deleteClientRequestValidator);
    private static GetAllClientsService getAllClientsService = new GetAllClientsService(database);
    private static ChangeClientAgeGroupService changeClientAgeGroupService = new ChangeClientAgeGroupService(database, changeClientAgeGroupValidator);
    private static ChangeClientWorkoutService changeClientWorkoutService = new ChangeClientWorkoutService(database, changeClientWorkoutsValidator);
    private static SearchClientService searchClientService = new SearchClientService(database, searchClientRequestValidator);

    private static UIAction addClientUIAction = new AddClientUIAction(addClientService);
    private static UIAction deleteClientUIAction = new RemoveClientUIAction(deleteClientService);
    private static UIAction getAllClientsUIAction = new GetAllClientsUIAction(getAllClientsService);
    private static UIAction changeClientAgeGroupUIAction = new ChangeClientAgeGroupUIAction(changeClientAgeGroupService);
    private static UIAction changeWorkoutUIAction = new ChangeWorkoutUIAction(changeClientWorkoutService);
    private static UIAction searchClientUIAction = new SearchClientUIAction(searchClientService);
    private static UIAction exitUIAction = new ExitUIAction();

    public static void main(String[] args) {

        while (true) {
            printProgramMenu();
            int userChoiceMenuNumber = getMenuNumber();
            switch (userChoiceMenuNumber) {
                case 1 -> addClientUIAction.execute();
                case 2 -> deleteClientUIAction.execute();
                case 3 -> getAllClientsUIAction.execute();
                case 4 -> changeWorkoutUIAction.execute();
                case 5 -> changeClientAgeGroupUIAction.execute();
                case 6 -> searchClientUIAction.execute();
                case 7 -> exitUIAction.execute();
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
