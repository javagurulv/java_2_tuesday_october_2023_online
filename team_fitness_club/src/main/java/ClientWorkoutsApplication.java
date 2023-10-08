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
                    System.out.println("Choose client workout.");
                    System.out.println("1. GYM");
                    System.out.println("2. Swimming Pool");
                    System.out.println("3. Group Classes");
                    int userChoiceWorkout = Integer.parseInt(scanner.nextLine());
                    Workouts clientWorkout = null;
                    switch (userChoiceWorkout) {
                        case 1: {
                            clientWorkout = Workouts.GYM;
                            break;
                        }
                        case 2: {
                            clientWorkout = Workouts.SWIMMING_POOL;
                            break;
                        }
                        case 3: {
                            clientWorkout = Workouts.GROUP_CLASSES;
                        }
                    }
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
                    System.out.println("Choose new workout.");
                    System.out.println("1. GYM");
                    System.out.println("2. Swimming Pool");
                    System.out.println("3. Group Classes");
                    int userChoiceWorkout = Integer.parseInt(scanner.nextLine());
                    switch (userChoiceWorkout){
                        case 1: {
                            for (Client client : clients) {
                                if (client.equals(changeClientWorkout)) {
                                    client.setWorkouts(Workouts.GYM);
                                }
                            }
                            System.out.println("Client workout has changed to GYM.");
                            break;
                        }
                        case 2: {
                            for (Client client : clients) {
                                if (client.equals(changeClientWorkout)) {
                                    client.setWorkouts(Workouts.SWIMMING_POOL);
                                }
                            }
                            System.out.println("Client workout has changed to Swimming Pool.");
                            break;
                        }
                        case 3: {
                            for (Client client : clients) {
                                if (client.equals(changeClientWorkout)) {
                                    client.setWorkouts(Workouts.GROUP_CLASSES);
                                }
                            }
                            System.out.println("Client workout has changed to Group Classes.");
                            break;
                        }
                    }
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
