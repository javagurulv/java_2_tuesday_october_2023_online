import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientWorkoutsApplication {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        while (true) {
            System.out.println("");
            System.out.println("Program menu:");
            System.out.println("1. Add client to list");
            System.out.println("2. Delete client from list");
            System.out.println("3. Show all clients in the list");
            System.out.println("4. Change client workout");
            System.out.println("5. Exit");

            System.out.println("");

            System.out.println("Enter menu item number to execute: ");
            Scanner scanner = new Scanner(System.in);
            int userChoice = Integer.parseInt(scanner.nextLine());
            int id = !clients.isEmpty() ? clients.get(clients.size() - 1).getId() + 1 : 1;
            switch (userChoice) {
                case 1: {
                    System.out.println("Enter client first name: ");
                    String clientFirstName = scanner.nextLine();
                    clientFirstName = (!clientFirstName.isEmpty()) ? clientFirstName.toLowerCase().substring(0, 1).
                            toUpperCase().concat(clientFirstName.substring(1)) : clientFirstName;
                    System.out.println("Enter client last name: ");
                    String clientLastName = scanner.nextLine();
                    clientLastName = (!clientLastName.isEmpty()) ? clientLastName.toLowerCase().substring(0, 1).
                            toUpperCase().concat(clientLastName.substring(1)) : clientLastName;
                    System.out.println("Enter client personal code: ");
                    String clientPersonalCode = scanner.nextLine();
                    System.out.println("Enter client workout: ");
                    Workouts clientWorkout = Workouts.valueOf(scanner.nextLine());
                    Client client = new Client(clientFirstName, clientLastName, clientPersonalCode, clientWorkout);
                    client.setId(id);
                    clients.add(client);
                    System.out.println("New client was added to list.");
                    break;
                }
                case 2: {
                    System.out.println("Enter client first name: ");
                    String clientFirstName = scanner.nextLine();
                    System.out.println("Enter client last name: ");
                    String clientLastName = scanner.nextLine();
                    System.out.println("Enter client personal code: ");
                    String clientPersonalCode = scanner.nextLine();
                    Client client = new Client(clientFirstName, clientLastName, clientPersonalCode);
                    clients.remove(client);
                    System.out.println("Client was removed from list. ");
                    break;
                }
                case 3: {
                    System.out.println("Clients list: ");
                    for (Client client : clients) {
                        System.out.println(client);
                    }
                    System.out.println("Client list end.");
                    break;
                }
                case 4: {
                    System.out.println("Change client workout: ");
                    System.out.println("Enter client first name: ");
                    String clientFirstName = scanner.nextLine();
                    System.out.println("Enter client last name: ");
                    String clientLastName = scanner.nextLine();
                    System.out.println("Enter client personal code: ");
                    String clientPersonalCode = scanner.nextLine();
                    Client changeClientWorkout = new Client(clientFirstName, clientLastName, clientPersonalCode);
                    System.out.println("Enter client new workout: ");
                    Workouts newWorkout = Workouts.valueOf(scanner.nextLine());
                    for (Client client : clients) {
                        if (client.equals(changeClientWorkout)) {
                            client.setWorkouts(newWorkout);
                        }
                    }
                    System.out.println("Client workout was changed.");
                    break;
                }
                case 5: {
                    System.out.println("All the best");
                    System.exit(0);
                }
            }
        }
    }
}
