package fitness_club.console_UI;

import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;
import fitness_club.requests.ClientAndWorkoutRequest;
import fitness_club.responses.ClientAndWorkoutResponse;
import fitness_club.services.AddClientService;
import fitness_club.services.GetClientAgeGroupService;
import fitness_club.services.GetWorkoutService;

import java.util.Scanner;

public class AddClientUIAction implements UIAction {
    private AddClientService service;

    public AddClientUIAction(AddClientService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("Choose client age group: ");
        System.out.println("1. Child");
        System.out.println("2. Adult");
        System.out.println("3. Senior");
        GetClientAgeGroupService getClientAgeGroupService = new GetClientAgeGroupService();
        ClientAgeGroups clientAgeGroups = getClientAgeGroupService.getClientAgeGroup(Integer.parseInt(scanner.nextLine()));
        System.out.println("Choose client workout.");
        System.out.println("1. GYM");
        System.out.println("2. Swimming Pool");
        System.out.println("3. Group Classes");
        GetWorkoutService getWorkoutService = new GetWorkoutService();
        Workouts clientWorkout = getWorkoutService.getWorkout(Integer.parseInt(scanner.nextLine()));

        ClientAndWorkoutRequest request = new ClientAndWorkoutRequest(clientFirstName, clientLastName, clientPersonalCode, clientAgeGroups, clientWorkout);
        ClientAndWorkoutResponse response = service.execute(request);

        System.out.println("New client was added to list.");
    }
}
