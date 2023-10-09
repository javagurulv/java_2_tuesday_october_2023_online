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
                case 1 -> {
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
                    Workouts clientWorkout = getWorkout(Integer.parseInt(scanner.nextLine()));
                    Client client = new Client(clientFirstName, clientLastName, clientPersonalCode, clientWorkout);
                    client.setId(id);
                    clients.add(client);
                    System.out.println("New client was added to list.");
                    break;
                }
                case 2 -> {
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
                case 3 -> {
                    System.out.println("Clients list: ");
                    for (Client client : clients) {
                        System.out.println(client);
                    }
                    System.out.println("Client list end.");
                    break;
                }
                case 4 -> {
                    System.out.println("Change client workout: ");
                    System.out.println("Enter client first name: ");
                    String clientFirstName = scanner.nextLine();
                    System.out.println("Enter client last name: ");
                    String clientLastName = scanner.nextLine();
                    System.out.println("Enter client personal code: ");
                    String clientPersonalCode = scanner.nextLine();
                    Client changeClientWorkout = new Client(clientFirstName, clientLastName, clientPersonalCode);
                    System.out.println("Choose new workout.");
                    System.out.println("1. GYM");
                    System.out.println("2. Swimming Pool");
                    System.out.println("3. Group Classes");

                    for (Client client : clients) {
                        if (client.equals(changeClientWorkout)) {
                            client.setWorkouts(getWorkout(Integer.parseInt(scanner.nextLine())));
                            break;
                        }
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("All the best");
                    System.exit(0);
                }
            }
        }
    }

    public static String formattedName(String name) {
        return name.toLowerCase().substring(0, 1).toUpperCase().concat(name.substring(1));
    }

    public static Workouts getWorkout(int id) {
        Workouts selectedWorkout = null;
        switch (id) {
            case 1 -> {
                selectedWorkout = Workouts.GYM;
            }
            case 2 -> {
                selectedWorkout = Workouts.SWIMMING_POOL;
            }
            case 3 -> {
                selectedWorkout = Workouts.GROUP_CLASSES;
            }
            default -> {
                System.out.println("No such workout option");
            }
        }
        return selectedWorkout;
    }
}
