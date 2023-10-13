import console_UI.ExitUIAction;
import console_UI.UIAction;
import database.*;
import domain.Workouts;
import services.*;
import java.util.Scanner;

public class ClientWorkoutsApplication {
    public static Database database = new InFileDatabase();

    private static UIAction exitUIAction = new ExitUIAction();

    public static void main(String[] args) {
        while (true) {
            printProgramMenu();
            int userChoiceMenuNumber = getMenuNumber();
            executeSelectedMenuItem(userChoiceMenuNumber);
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

    public static void executeSelectedMenuItem(int menuNumber) {
        switch (menuNumber) {
            case 1 -> addNewClientToList(database);
            case 2 -> removeClientFromList(database);
            case 3 -> printClientList(database);
            case 4 -> changeClientWorkout(database);
            case 5 -> exitFromProgram();
        }
    }

    private static void exitFromProgram() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private static void changeClientWorkout(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client workout: ");
        System.out.println("Enter client first name: ");
        String clientFirstName = scanner.nextLine();
        System.out.println("Enter client last name: ");
        String clientLastName = scanner.nextLine();
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        System.out.println("Choose new workout.");
        System.out.println("1. GYM");
        System.out.println("2. Swimming Pool");
        System.out.println("3. Group Classes");
        GetWorkoutService getWorkoutService = new GetWorkoutService();
        Workouts newWorkout = getWorkoutService.getWorkout(Integer.parseInt(scanner.nextLine()));
        ChangeClientWorkoutService changeClientWorkoutService = new ChangeClientWorkoutService(database);
        changeClientWorkoutService.changeClientWorkout(clientFirstName, clientLastName, clientPersonalCode, newWorkout);
        System.out.println("Client workout has been changed.");
    }

    private static void printClientList(Database database) {
        System.out.println("Clients list: ");
        GetAllClientsService getAllClientsService = new GetAllClientsService(database);
        getAllClientsService.execute().forEach(System.out::println);
        System.out.println("Client list end.");
    }

    private static void removeClientFromList(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name: ");
        String clientFirstName = scanner.nextLine();
        System.out.println("Enter client last name: ");
        String clientLastName = scanner.nextLine();
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        RemoveClientService removeClientService = new RemoveClientService(database);
        removeClientService.removeClient(clientFirstName, clientLastName, clientPersonalCode);
        System.out.println("Client was removed from list. ");
    }

    private static void addNewClientToList(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name: ");
        String clientFirstName = formattedName(scanner.nextLine());
        System.out.println("Enter client last name: ");
        String clientLastName = formattedName(scanner.nextLine());
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        System.out.println("Choose client workout.");
        System.out.println("1. GYM");
        System.out.println("2. Swimming Pool");
        System.out.println("3. Group Classes");
        GetWorkoutService getWorkoutService = new GetWorkoutService();
        Workouts clientWorkout = getWorkoutService.getWorkout(Integer.parseInt(scanner.nextLine()));
        AddClientService addClientService = new AddClientService(database);
        addClientService.addClient(clientFirstName, clientLastName, clientPersonalCode, clientWorkout);
        System.out.println("New client was added to list.");
    }


    public static String formattedName(String name) {
        return name.toLowerCase().substring(0, 1).toUpperCase().concat(name.substring(1));
    }

}
